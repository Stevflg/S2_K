package com.example.s2_k.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.example.s2_k.Data.IMC
import com.example.s2_k.Data.Triangulo


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Ejercicio_4(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Ejercicio 4",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }){
        Spacer(modifier = Modifier.size(20.dp))
        Content_4(navController)
    }
}
var msjImc:String= ""
var imc=IMC()
@Composable
fun Content_4(navController: NavController){

    var Weight by remember { mutableStateOf("") }
    var Height by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Text("Indice de Masa Corporal",
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 30.dp, end = 30.dp))
        Spacer(modifier = Modifier.size(20.dp))


        OutlinedTextField(
            value = Weight, onValueChange = { Weight = it },
            label = { Text("Peso") },
            placeholder ={ Text ("Peso en Kilos") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )

        OutlinedTextField(
            value = Height, onValueChange = { Height = it },
            label = { Text("Altura") },
            placeholder ={ Text ("Altura en Metros") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.size(40.dp))

        val openDialog = remember { mutableStateOf(false) }

        Button(onClick = {
            try {
                if(Weight.toDouble() is Double && Height.toDouble() is Double)
                {
                    imc.setDatos(Weight.toDouble(),Height.toDouble())
                    openDialog.value=true
                    msjImc=imc.Mostar_Resultado()
                    Weight=""
                    Height=""
                }
                else{
                    openDialog.value=true
                    if(openDialog.value){
                        msjImc="Compruebe los datos proporcionados"
                        Weight=""
                        Height=""
                    }
                }
            }catch (e: Exception){
                openDialog.value=true
                if(openDialog.value){
                    msjImc="Compruebe los datos proporcionados"
                    Weight=""
                    Height=""
                }
            }
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Comprobar", fontSize = 20.sp, color = Color.White)
        }

        if (openDialog.value){
            openDialog.value= Alert(mensaje = msjImc, Titulo = "Resultado",openDialog.value)
        } } }

