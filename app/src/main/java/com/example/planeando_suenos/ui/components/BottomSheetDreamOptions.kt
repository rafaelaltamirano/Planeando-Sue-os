package com.example.planeando_suenos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planeando_suenos.domain.entities.PriorityDream
import com.example.planeando_suenos.ui.main.MainViewModel
import com.example.planeando_suenos.ui.screens.home.emulateDreamsStep.EmulateDreamsViewModel
import com.example.planeando_suenos.ui.theme.GreenBusiness
import com.example.planeando_suenos.ui.theme.TextColorUncheckedItemDreamGrid
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetDreamOptions(
    onNext: (String) -> Unit,
    model: EmulateDreamsViewModel,
    contentCredit: Boolean = false,
    child: @Composable (() -> Unit) -> Unit,
) {

    val state =
        rememberModalBottomSheetState(ModalBottomSheetValue.Hidden,
            confirmStateChange = {
                it != ModalBottomSheetValue.HalfExpanded
            })
    val coroutine = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
            if (contentCredit) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 24.dp, end = 8.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Gracias por participar de esta prueba ",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    )
                    IconButton(onClick = {
                        model.setCancelOnNext(false)
                        coroutine.launch { state.hide() }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Close",
                            tint = GreenBusiness
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Text(
                        text = "Al participar de esta prueba NO estas pidiendo ning??n cr??dito.",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    )
                    Spacer(modifier = Modifier.height(26.dp))
                    Text(
                        text = "Si est??s interesado por favor entra en contacto con el equipo de atenci??n al cliente",
                        style = TextStyle(
                            color = TextColorUncheckedItemDreamGrid,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                    Spacer(modifier = Modifier.height(200.dp))
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 24.dp, end = 8.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "??C??mo quieres cumplir tus sue??os?",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    )
                    IconButton(onClick = {
                        model.setCancelOnNext(false)
                        coroutine.launch { state.hide() }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Close",
                            tint = GreenBusiness
                        )
                    }
                }
                ItemTextBottomSheetDream(
                    "Tu sue??o m??s peque??o primero",
                    "Podr??s cumplir tus sue??os en orden, partiendo desde el m??s peque??o."
                ) {
                    onNext(PriorityDream.LowestFirst.priority)
                    coroutine.launch { state.hide() }
                }
                Spacer(modifier = Modifier.height(16.dp))
                ItemTextBottomSheetDream(
                    "Todos tus sue??os al mismo tiempo",
                    "Todos tus sue??os al mismo tiempo. Tus cuotas siempre tendran el mismo valor."
                ) {
                    onNext(PriorityDream.AllAtSameTime.priority)
                    coroutine.launch { state.hide() }
                }
                Spacer(modifier = Modifier.height(16.dp))
                ItemTextBottomSheetDream(
                    "Tu sue??o m??s grande primero",
                    "Pagar??s mas al principio pero tendr??s tu mayor recompensa."
                ) {
                    onNext(PriorityDream.BiggestFirst.priority)
                    coroutine.launch { state.hide() }
                }
                Spacer(modifier = Modifier.height(16.dp))

            }
        },
        sheetShape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        sheetBackgroundColor = Color.White,
        sheetState = state
    ) {

        child()
        {
            coroutine.launch {
                state.animateTo(ModalBottomSheetValue.Expanded)
            }
        }
    }
}

@Composable
fun ItemTextBottomSheetDream(title: String, subTitle: String, onClickItem: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {

        Text(text = title, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = subTitle,
            style = TextStyle(
                color = TextColorUncheckedItemDreamGrid,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.clickable { onClickItem() },
            text = "Ver cronograma de pago",
            style = TextStyle(
                color = Color(0xFF9D4BEB),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline
            )
        )

    }
}
