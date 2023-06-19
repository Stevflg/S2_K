package com.example.s2_k.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.s2_k.navigation.AppScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Main(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "Menu Principal",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))
        }
    }) {
        Spacer(modifier = Modifier.size(20.dp))
        BodyContent(navController)
    }
}
@Composable
fun BodyContent(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally ) {

        Button(onClick = { navController.navigate(route = AppScreens.Ejercicio_1.route) }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 50.dp)) {
            Text(text = "Ejercicio 1", fontSize = 20.sp, color = Color.White)
        }
        Button(onClick = { navController.navigate(route = AppScreens.Ejercicio_2.route) }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Ejercicio 2", fontSize = 20.sp, color = Color.White)
        }
        Button(onClick = { navController.navigate(route = AppScreens.Ejercicio_3.route) }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Ejercicio 3", fontSize = 20.sp, color = Color.White)
        }
        Button(onClick = { navController.navigate(route = AppScreens.Ejercicio_4.route) }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Ejercicio 4", fontSize = 20.sp, color = Color.White)
        }
        Button(onClick = { navController.navigate(route = AppScreens.Ejercicio_5.route) }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
            modifier = Modifier.padding(top = 20.dp)) {
            Text(text = "Ejercicio 5", fontSize = 20.sp, color = Color.White)
        }
    }
}
