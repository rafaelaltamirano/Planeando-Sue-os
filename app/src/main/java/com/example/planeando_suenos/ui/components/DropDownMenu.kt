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
    onUp: () -> Unit,
    onDown: () -> Unit,
    position: Int,
    lastPosition: Int,
) {
    DropdownMenu(
        offset = DpOffset(x = (20).dp, y = (0).dp),
        expanded = expandedNested.value,
        onDismissRequest = {
            expandedNested.value = false
        }
    ) {
        when (position) {
            0 -> {
                DropdownMenuItem(
                    onClick = {
                        onDown()
                        expandedNested.value = false
                    }
                ) {
                    Text("Bajar Priorización")
                }
            }
            lastPosition -> {
                DropdownMenuItem(
                    onClick = {
                        onUp()
                        expandedNested.value = false
                    }
                ) {
                    Text("Subir Priorización")
                }
            }
            else -> {
                DropdownMenuItem(
                    onClick = {
                        onDown()
                        expandedNested.value = false
                    }
                ) {
                    Text("Bajar Priorización")
                }
                DropdownMenuItem(
                    onClick = {
                        onUp()
                        expandedNested.value = false
                    }
                ) {
                    Text("Subir Priorización")
                }
            }
        }


    }
}