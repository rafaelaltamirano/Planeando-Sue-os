package com.example.planeando_suenos.ui.components

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun NestedMenu(
    expandedNested: MutableState<Boolean>,
//    position: Int = remember{ mutableStateOf(0)}
) {
    DropdownMenu(
        offset = DpOffset(x = (20).dp, y = (0).dp),
        expanded = expandedNested.value,
        onDismissRequest = {
            expandedNested.value = false
        }
    ) {
        DropdownMenuItem(
            onClick = {
                // close nested menu
                expandedNested.value = false
            }
        ) {
            Text("Subir Priorización")
        }
        DropdownMenuItem(
            onClick = {
                // close nested menu
                expandedNested.value = false
            }
        ) {
            Text("Bajar Priorización")
        }
    }
}