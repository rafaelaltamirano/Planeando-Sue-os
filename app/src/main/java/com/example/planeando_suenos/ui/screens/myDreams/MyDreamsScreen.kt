package com.example.planeando_suenos.ui.screens.myDreams

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CardTextDetail
import com.example.planeando_suenos.ui.components.TopBarClearWithBack
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.UserRouterDir

@Composable
fun MyDreamsScreen(mainModel: MainViewModel, navController: NavHostController) {
    var dreamList = mainModel.state.dreamWithUser
    Column {
        TopBarClearWithBack(
            title = "Mis planes guardados",
            bigFont = false,
            onBackPress = {
                navController.navigate(UserRouterDir.HOME.route)
            })

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