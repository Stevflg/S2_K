package com.example.s2_k.Screens

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Alert(mensaje: String, Titulo: String,State: Boolean):Boolean{
    val value = remember { mutableStateOf(State) }
    AlertDialog(onDismissRequest = {value.value=false },
        title = { Text(text = Titulo, textAlign = TextAlign.Center) },
        text = { Text(text = mensaje, textAlign = TextAlign.Justify) },
        confirmButton = { Button(onClick = {
            value.value =false }) {
            Text("OK")
        }
        })
    return value.value
}