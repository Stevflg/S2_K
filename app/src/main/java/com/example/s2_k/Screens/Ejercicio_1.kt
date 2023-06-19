package com.example.s2_k.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s2_k.Data.Triangulo
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.runtime.remember as remember

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Ejercicio_1(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
            modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Ejercicio 1",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }){
        Spacer(modifier = Modifier.size(20.dp))
        Content_1(navController)
    }
}
var triangulo= Triangulo()
@Composable
fun Content_1(navController: NavController){

    var lado1 by remember { mutableStateOf("") }
    var lado2 by remember { mutableStateOf("") }
    var lado3 by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Text("El siguiente ejercicio Comprobara si el triangulo es" +
                "equilatero o no",
            fontSize = 18.sp,
        modifier = Modifier.padding(start = 30.dp, end = 30.dp))
        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = lado1, onValueChange = { lado1 = it },
            label = { Text("Lado 1") },
            placeholder ={Text ("Lado 1")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )

        OutlinedTextField(
            value = lado2, onValueChange = { lado2 = it },
            label = { Text("Lado 2") },
            placeholder ={Text ("Lado 2")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )

        OutlinedTextField(
            value = lado3, onValueChange = { lado3 = it },
            label = { Text("Lado 3") },
            placeholder ={Text ("Lado 3")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.size(40.dp))

        val openDialog = remember { mutableStateOf(false) }

        Button(onClick = {
            try {
                triangulo.CargarDatos(lado1.toInt(),lado2.toInt(),lado3.toInt())
                openDialog.value=true
            }catch (e: Exception){
            }

        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Comprobar", fontSize = 20.sp, color = Color.White)
        }

        if (openDialog.value){
            var mensaje= triangulo.lado_mayor() +"\n"+ triangulo.comprobar()
            AlertDialog(onDismissRequest = {openDialog.value=false },
                title = { Text(text = "Resultado", textAlign = TextAlign.Center)},
                text = { Text(text = mensaje)},
                confirmButton = { Button(onClick = {
                    lado1=""
                    lado2=""
                    lado3=""
                    openDialog.value = false
                }) {
                    Text("OK")
                }})
        }
    }
}

