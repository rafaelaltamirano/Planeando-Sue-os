package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.dreamsList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.R
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBarWithText
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.router.PublicRouterDir
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.theme.*

@Composable
fun DreamListStep(
    onNext: () -> Unit,
    onSubmit: () -> Unit,
    model: EmulateDreamsViewModel,
    mainModel: MainViewModel,
) {
    Column(
        Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    )
    {
        TopBarWithText("Todos tus sueños al mismo tiempo")

        Column(
            Modifier
                .padding(dimensionResource(R.dimen.gap4))
                .fillMaxHeight()
        ) {
            Text(
                modifier = Modifier.padding(vertical = 24.dp),
                style = MaterialTheme.typography.caption,
                color = TextColorUncheckedItemDreamGrid,
                text = "Ajusta el monto mensual para cada sueño y busca tu priorización ideal. Ordena tus sueños según tu prioridad.",
                fontSize = 14.sp,
            )

            Text(
                "Selecciona otra priorización  > ",
                color = Accent,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .clickable(onClick = { })
            )
            Spacer(Modifier.height(24.dp))
            DreamRow(
                position = "1",
                colors = TextCardGreen,
                dreamTitle = "Comprar muebles nuevos",
                dreamAmount = "246.33"
            )
            Spacer(modifier = Modifier.height(22.dp))
            DreamRow(
                position = "2",
                colors = TextCardBlue,
                dreamTitle = "Construir / Remodelar",
                dreamAmount = "246.33"
            )
            Spacer(modifier = Modifier.height(22.dp))
            DreamRow(
                position = "3",
                colors = TextCardYellow,
                dreamTitle = "Línea blanca",
                dreamAmount = "246.33"
            )

            Spacer(Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Start,
                    text = "Capacidad disponible",
                    fontSize = 12.sp,
                )
                Text(
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.caption,
                    text = " \$ 739.40",
                    textAlign = TextAlign.Start,
                    fontWeight = W800,
                    fontSize = 18.sp,
                )
            }
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                style = MaterialTheme.typography.caption,
                color = TextColorUncheckedItemDreamGrid,
                text = "Para aumentar tu capacidad debes aumentar tus ingresos o bajar tus egresos\n",
                fontSize = 14.sp,
            )
            Spacer(Modifier.height(16.dp))
            SubmitButton(
                text = "guardar plan",
                onClick = onSubmit
            )
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Ver cronograma",
                    color = Accent,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .clickable(onClick =  onNext)
                )
            }
        }
    }
}


@Composable
fun DreamRow(
    position: String,
    colors: Color,
    dreamTitle: String,
    dreamAmount: String
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(28.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Card(
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .fillMaxHeight()
                .weight(05f),
            backgroundColor = BackgroundUncheckedItemDreamGrid,

            )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    fontSize = 13.sp,
                    text = "$position."
                )
            }
        }
        Card(
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .weight(80f)
                .fillMaxHeight(),
            elevation = 0.dp,
            backgroundColor = colors.copy(alpha = 0.2f),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    color = colors.copy(alpha = 1f),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.caption,
                    fontSize = 13.sp,
                    text = dreamTitle
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end=12.dp),
                    color = colors.copy(alpha = 1f),
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    fontSize = 13.sp,
                    fontWeight = W900,
                    text = "\$$dreamAmount"
                )
            }
        }
        Card(
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .fillMaxHeight()
                .weight(05f),
            backgroundColor = BackgroundUncheckedItemDreamGrid,

            )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    fontSize = 13.sp,
                    text = "-"
                )
            }
        }
        Card(
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .fillMaxHeight()
                .weight(05f),
            backgroundColor = BackgroundUncheckedItemDreamGrid,

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    fontSize = 13.sp,
                    text = "+"
                )
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DreamRowPreview() {
    DreamRow(
        "1",
        TextCardGreen,
        "Comprar muebles nuevos",
        "246.33"
    )
}

