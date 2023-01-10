package com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.dreamsList

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import com.example.planeando_suenos.R
import com.example.planeando_suenos.domain.body.smartShopping.Dream
import com.example.planeando_suenos.ui.components.SubmitButton
import com.example.planeando_suenos.ui.components.TopBarWithText
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.theme.*

@Composable
fun DreamListStep(
    onNext: () -> Unit,
    onSubmit: () -> Unit,
    model: EmulateDreamsViewModel,
    mainModel: MainViewModel,
    onShowBottomSheet: () -> Unit,
) {
    val state = model.state
//    val dreamId = "63bc8479d97880ed1b56f034"
    //TODO: CHANGE
    val dreamId = mainModel.state.dreamId!!
    val priority = model.state.prioritySelected

    LaunchedEffect(Unit) {
        model.getDream(dreamId, priority ?: "equal")
    }

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
                    .clickable(onClick = { onShowBottomSheet() }),
            )
            Spacer(Modifier.height(24.dp))
            if (model.state.loading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp),
                        color = Accent
                    )
                }
            } else {
                state.dreamWithUser?.dream?.forEachIndexed { index, dream ->
                    DreamRow(
                        position = (index + 1).toString(),
                        colors = dream.color,
                        dreamTitle = dream.description,
                        dreamAmount = dream.amount.toString(),
                        onSum = {
                            if (index == state.dreamWithUser.dream.lastIndex) {
                                model.setNewDreamListUpdate(Dream(
                                    description = state.dreamWithUser.dream[0].description,
                                    amount = state.dreamWithUser.dream[0].amount?.minus(10),
                                    startDate = state.dreamWithUser.dream[0].startDate,
                                    endDate = state.dreamWithUser.dream[0].endDate,
                                    amountPlaned = state.dreamWithUser.dream[0].amountPlaned,
                                    paymentQuantity = state.dreamWithUser.dream[0].paymentQuantity,
                                    dreamType = state.dreamWithUser.dream[0].dreamType,
                                    color = state.dreamWithUser.dream[0].color
                                ),0)

                                model.setNewDreamListUpdate(Dream(
                                    description = dream.description,
                                    amount = dream.amount?.plus(10),
                                    startDate = dream.startDate,
                                    endDate = dream.endDate,
                                    amountPlaned = dream.amountPlaned,
                                    paymentQuantity = dream.paymentQuantity,
                                    dreamType = dream.dreamType,
                                    color = dream.color
                                ),index)
                            } else {
                                model.setNewDreamListUpdate(Dream(
                                    description = dream.description,
                                    amount = dream.amount?.plus(10),
                                    startDate = dream.startDate,
                                    endDate = dream.endDate,
                                    amountPlaned = dream.amountPlaned,
                                    paymentQuantity = dream.paymentQuantity,
                                    dreamType = dream.dreamType,
                                    color = dream.color
                                ),index)

                                model.setNewDreamListUpdate(Dream(
                                    description = state.dreamWithUser.dream[index + 1].description,
                                    amount = state.dreamWithUser.dream[index + 1].amount?.minus(10),
                                    startDate = state.dreamWithUser.dream[index + 1].startDate,
                                    endDate = state.dreamWithUser.dream[index + 1].endDate,
                                    amountPlaned = state.dreamWithUser.dream[index + 1].amountPlaned,
                                    paymentQuantity = state.dreamWithUser.dream[index + 1].paymentQuantity,
                                    dreamType = state.dreamWithUser.dream[index + 1].dreamType,
                                    color = state.dreamWithUser.dream[index + 1].color
                                ),index+1)
                            }

                        },
                        onRest = {
                            if (index == state.dreamWithUser.dream.lastIndex) {
                                model.setNewDreamListUpdate(Dream(
                                    description = state.dreamWithUser.dream[0].description,
                                    amount = state.dreamWithUser.dream[0].amount?.plus(10),
                                    startDate = state.dreamWithUser.dream[0].startDate,
                                    endDate = state.dreamWithUser.dream[0].endDate,
                                    amountPlaned = state.dreamWithUser.dream[0].amountPlaned,
                                    paymentQuantity = state.dreamWithUser.dream[0].paymentQuantity,
                                    dreamType = state.dreamWithUser.dream[0].dreamType,
                                    color = state.dreamWithUser.dream[0].color
                                ),0)

                                model.setNewDreamListUpdate(Dream(
                                    description = dream.description,
                                    amount = dream.amount?.minus(10),
                                    startDate = dream.startDate,
                                    endDate = dream.endDate,
                                    amountPlaned = dream.amountPlaned,
                                    paymentQuantity = dream.paymentQuantity,
                                    dreamType = dream.dreamType,
                                    color = dream.color
                                ),index)

                            } else {
                                model.setNewDreamListUpdate(Dream(
                                    description = dream.description,
                                    amount = dream.amount?.minus(10),
                                    startDate = dream.startDate,
                                    endDate = dream.endDate,
                                    amountPlaned = dream.amountPlaned,
                                    paymentQuantity = dream.paymentQuantity,
                                    dreamType = dream.dreamType,
                                    color = dream.color
                                ),index)
                                model.setNewDreamListUpdate(Dream(
                                    description = state.dreamWithUser.dream[index + 1].description,
                                    amount = state.dreamWithUser.dream[index + 1].amount?.plus(10),
                                    startDate = state.dreamWithUser.dream[index + 1].startDate,
                                    endDate = state.dreamWithUser.dream[index + 1].endDate,
                                    amountPlaned = state.dreamWithUser.dream[index + 1].amountPlaned,
                                    paymentQuantity = state.dreamWithUser.dream[index + 1].paymentQuantity,
                                    dreamType = state.dreamWithUser.dream[index + 1].dreamType,
                                    color = state.dreamWithUser.dream[index + 1].color
                                ),index + 1)
                            }
                        }
                    )
                    Spacer(Modifier.height(6.dp))
                }
            }
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
                    text = "Monto disponible",
                    fontSize = 12.sp,
                )

                if (model.state.loading) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .height(6.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(6.dp)
                                .height(6.dp),
                            color = Accent
                        )
                    }
                } else {
                    Text(
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.caption,
                        text = " \$ ${state.dreamWithUser?.userFinance?.paymentCapability}",
                        textAlign = TextAlign.Start,
                        fontWeight = W800,
                        fontSize = 18.sp,
                    )
                }
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
                text = "ver calendario",
                onClick = onNext
            )
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Guardar plan de sueños",
                    color = Accent,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier
                        .clickable(onClick = onSubmit)
                )
            }
        }
    }
}
@Composable
fun DreamList(
) {

}




@Composable
fun DreamRow(
    position: String,
    colors: String? = null,
    dreamTitle: String? = null,
    dreamAmount: String? = null,
    onSum: () -> Unit,
    onRest: () -> Unit
) {

    val colorString = colors ?: "0x00000000"
    val color = Color(colorString.toColorInt())
//    val color = GreenBusiness
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
            backgroundColor = color.copy(alpha = 0.2f),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    color = color.copy(alpha = 1f),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.caption,
                    fontSize = 13.sp,
                    text = dreamTitle ?: ""
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 12.dp),
                    color = color.copy(alpha = 1f),
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
                    .fillMaxHeight()
                    .clickable {
                        onRest()
                    },
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
                    .fillMaxHeight()
                    .clickable {
                        onSum()
                    },
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

