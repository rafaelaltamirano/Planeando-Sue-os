package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.saveDream

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.CustomTextField
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.theme.GreenBusiness

@Composable
fun SaveDreamStep(
    model: EmulateDreamsViewModel,
    onNext: () -> Unit
) {
    val checkedState = remember { mutableStateOf(false) }

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
            onDone = true,
            onValueChanged = model::setDreamName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.gap4))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Checkbox(
                colors = CheckboxDefaults.colors(checkedColor = GreenBusiness),
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                    model.setDreamSendToEmail(it)
                }
            )
            Text(
                text = "Enviar una copia al correo electrónico",
                color = Color.Black,
                fontWeight = FontWeight.W400,
                fontSize = 15.sp,
            )
        }
        Spacer(modifier = Modifier.height(33.dp))
        SubmitButton(
            text = "guardar",
            enabled = model.state.dreamName!= "",
            loading = model.state.loading,
            onClick =  onNext,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.gap3),
                    horizontal = dimensionResource(R.dimen.gap6)
                )
        )

    }

}