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
import com.example.s2_k.Data.Alumno
import com.example.s2_k.Data.Triangulo

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Ejercicio_2(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Ejercicio 2",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }){
        Spacer(modifier = Modifier.size(20.dp))
        Content_2(navController)
    }
}
var mensaje: String=""
var alumno= Alumno()
@Composable
fun Content_2(navController: NavController){

    var Name by remember { mutableStateOf("") }
    var Surname by remember { mutableStateOf("") }
    var Score by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text("El siguiente ejercicio Comprobara nota del alumno",
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 30.dp, end = 30.dp))
        Spacer(modifier = Modifier.size(20.dp))


        OutlinedTextField(
            value = Name, onValueChange = { Name = it },
            label = { Text("Nombre") },
            placeholder ={ Text ("Nombre") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.padding(top = 10.dp)
        )

        OutlinedTextField(
            value = Surname, onValueChange = {Surname = it },
            label = { Text("Apellido") },
            placeholder ={ Text ("Apellido") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.padding(top = 10.dp)
        )

        OutlinedTextField(
            value = Score, onValueChange = { Score = it },
            label = { Text("Puntaje") },
            placeholder ={ Text ("Rango del (1-10)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.size(40.dp))

        val openDialog = remember { mutableStateOf(false) }

        Button(onClick = {
            try {
                if(Name is String && Surname is String && Score.toDouble() is Double && (Score.toDouble()>=0 && Score.toDouble()<11) ){
                    alumno.setName(Name)
                    alumno.setSurname(Surname)
                    alumno.setScore(Score.toDouble())
                    openDialog.value=true
                    mensaje= alumno.Mostrar()
                    Name=""
                    Surname=""
                    Score=""
                }
                else{
                    openDialog.value=true
                    if(openDialog.value){
                        mensaje="Compruebe los datos proporcionados"
                        Score=""
                    }
                }
            }catch (e: Exception){
                openDialog.value=true
                if(openDialog.value){
                    mensaje="Compruebe los datos proporcionados"
                    Score=""
                }
            }
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Comprobar", fontSize = 20.sp, color = Color.White)
        }

        if (openDialog.value){

            /*AlertDialog(onDismissRequest = {openDialog.value=false },
                title = { Text(text = "Resultado") },
                text = { Text(text = mensaje) },
                confirmButton = { Button(onClick = {
                    openDialog.value = false }) {
                    Text("OK")
                }
                })*/
           // openDialog.value=false
            openDialog.value= Alert(mensaje = mensaje, Titulo = "Resultado",openDialog.value)
        } } }

