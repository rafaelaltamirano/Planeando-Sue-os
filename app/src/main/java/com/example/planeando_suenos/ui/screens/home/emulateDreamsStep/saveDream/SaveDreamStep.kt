package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.saveDream

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import kotlin.reflect.KFunction0

@Composable
fun SaveDreamStep(
    model: EmulateDreamsViewModel,
    onNext: () -> Unit,
) {

    Column(
        Modifier
            .padding(dimensionResource(R.dimen.gap4))
            .fillMaxHeight()
    ) {
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Guarda tu plan de sueños, podrás modificarlo o revisarlo cuantas veces creas necesario.",
            fontSize = 15.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontSize = 17.sp,
            text = "Nombre del sueño"
        )

        CustomTextField(
            value = model.state.dreamName,
            placeholder = R.string.my_dream_example,
            onValueChanged = model::setDreamName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Spacer(modifier = Modifier.height(16.dp))
        SubmitButton(
            onClick = {
                onNext()
            },
            text = "guardar",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.gap3),
                    horizontal = dimensionResource(R.dimen.gap6)
                )
        )

    }

}