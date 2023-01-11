package com.example.planeando_suenos.ui.screens.myDreams

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CardTextDetail
import com.example.planeando_suenos.ui.components.TopBarClearWithBack
import com.example.planeando_suenos.ui.main.MainViewModel

@Composable
fun MyDreamsScreen(mainModel: MainViewModel) {
    val dreamList = mainModel.state.dreamWithUser
    Column {
        TopBarClearWithBack(
            title = "Mis planes guardados",
            bigFont = false,
            onBackPress = {})

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = dimensionResource(id = R.dimen.gap4))
        ) {
            dreamList?.forEach {
                CardTextDetail(title = it.title, onPress = {})
            }
        }
    }
}