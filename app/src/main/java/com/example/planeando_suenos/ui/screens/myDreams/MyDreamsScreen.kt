package com.example.planeando_suenos.ui.screens.myDreams

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CardTextDetail
import com.example.planeando_suenos.ui.components.TopBarClearWithBack
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir
import com.example.planeando_suenos.ui.screens.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun MyDreamsScreen(
    mainModel: MainViewModel,
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {

    if (homeViewModel.state.dreamWithUserList == null) {
        LaunchedEffect(Unit) { homeViewModel.getDream() }
    }

    val dreamList = homeViewModel.state.dreamWithUserList
    Column {
        TopBarClearWithBack(
            title = "Mis planes guardados",
            bigFont = false,
            onBackPress = {
                navController.navigate(UserRouterDir.HOME.route)
                mainModel.setDreamId(null)
                mainModel.setDreamEdit(null)
                homeViewModel.setCheckedStep1(false)
                homeViewModel.setCheckedStep2(false)
                homeViewModel.setCheckedStep3(false)
            })
        if (homeViewModel.state.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = dimensionResource(id = R.dimen.gap4))
            ) {

                dreamList?.map {
                    if (!it.title.isNullOrEmpty()) {
                        CardTextDetail(title = it.title, onPress = {
                            mainModel.setDreamId(it.id)
                            navController.navigate(UserRouterDir.EMULATE_DREAM.route)
                        })
                    }
                }
            }
        }
    }
}