package com.example.planeando_suenos.ui.screens.home.savedDreams

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CardTextDetail
import com.example.planeando_suenos.ui.components.TopBarClearWithBack

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SavedDreamsScreen() {
    Column {
        TopBarClearWithBack(title = "Mis planes guardados", bigFont = false, onBackPress = {

        })

        Column(
            modifier = Modifier.padding(
                horizontal = dimensionResource(id = R.dimen.gap5)
            )
        ) {
            CardTextDetail(title = "Test", onPress = {})
            CardTextDetail(title = "Test", onPress = {})
            CardTextDetail(title = "Test", onPress = {})
            CardTextDetail(title = "Test", onPress = {})
            CardTextDetail(title = "Test", onPress = {})
            CardTextDetail(title = "Test", onPress = {})
        }
    }
}