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
import com.example.s2_k.Data.Persona
import com.example.s2_k.Data.Triangulo


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Ejercicio_3(navController: NavController){
    Scaffold (topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "Ejercicio 3",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }){
        Spacer(modifier = Modifier.size(20.dp))
        Content_3(navController)
    }
}
var msjPerson: String=""
val person= Persona()
@Composable
fun Content_3(navController: NavController){

    var Name by remember { mutableStateOf("") }
    var Surname by remember { mutableStateOf("") }
    var Age by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Spacer(modifier = Modifier.size(20.dp))
        Text("Implementacion de la clase Persona",
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.padding(top = 10.dp)
        )

        OutlinedTextField(
            value = Age, onValueChange = { Age = it },
            label = { Text("Edad") },
            placeholder ={ Text ("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.size(40.dp))

        val openDialog = remember { mutableStateOf(false) }

        Button(onClick = {
            try {
                if(Name is String && Surname is String && Age.toInt() is Int && (Age.toInt()>0 && Age.toInt()<100))
                {
                    person.SetName(Name)
                    person.SetSurName(Surname)
                    person.SetAge(Age.toInt())
                    openDialog.value=true
                    msjPerson= person.Mostrar()
                    Name=""
                    Surname=""
                    Age=""
                }
                else{
                    openDialog.value=true
                    if(openDialog.value){
                        msjPerson="Compruebe los datos"
                        Age=""
                    }
                }
            }catch (e: Exception){
                openDialog.value=true
                if(openDialog.value){
                    msjPerson="Compruebe los datos"
                    Age=""
                }
            }
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Comprobar", fontSize = 20.sp, color = Color.White)
        }

        if (openDialog.value){
            openDialog.value= Alert(mensaje = msjPerson, Titulo = "Resultado",openDialog.value)
        } } }

