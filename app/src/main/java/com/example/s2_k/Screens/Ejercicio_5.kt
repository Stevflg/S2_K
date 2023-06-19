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
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s2_k.Data.Empleado
import com.example.s2_k.Data.Triangulo
import java.util.jar.Attributes.Name


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Ejercicio_5(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Ejercicio 5",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }){
        Spacer(modifier = Modifier.size(20.dp))
        Content_5(navController)
    }
}
var msjempleado:String=""
var empleado= Empleado()
@Composable
fun Content_5(navController: NavController){

    var Name by remember { mutableStateOf("") }
    var Surname by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Text("Datos de Empleado",
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
            value = Surname, onValueChange = { Surname = it },
            label = { Text("Apellido") },
            placeholder ={ Text ("Apellido") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text ),
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.size(40.dp))

        val openDialog = remember { mutableStateOf(false) }

        Row(verticalAlignment =Alignment.CenterVertically) {
            Button(onClick = {
                try {
                    if(Name != "" && Surname!= ""){
                    empleado.SetName(Name)
                    empleado.SetSurName(Surname)
                    openDialog.value=true
                    msjempleado= empleado.Mostrar()
                    Name=""
                    Surname=""}
                    else{
                    msjempleado="Los campos no pueden estar Vacios"
                    openDialog.value=true
                    }
                }
                catch (e: Exception){

                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                modifier = Modifier.padding(top = 20.dp))
            {
                Text(text = "Actualizar", fontSize = 20.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(onClick = {
                try {
                    openDialog.value=true
                    msjempleado= empleado.Mostrar()
                }
                catch (e: Exception){

                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                modifier = Modifier.padding(top = 20.dp))
            {
                Text(text = "Visualizar", fontSize = 20.sp, color = Color.White)
            }
        }

        if (openDialog.value){
            openDialog.value= Alert(mensaje = msjempleado, Titulo = "Datos", State = openDialog.value)
        }
    }
}