package com.example.s2_k.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AndroidUiDispatcher.Companion.Main
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.s2_k.Screens.*

@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Main.route){
        composable(route = AppScreens.Main.route){
            Main(navController)
        }
        composable(route = AppScreens.Ejercicio_1.route){
            Ejercicio_1(navController)
        }
        composable(route = AppScreens.Ejercicio_2.route){
            Ejercicio_2(navController)
        }
        composable(route = AppScreens.Ejercicio_3.route){
            Ejercicio_3(navController)
        }
        composable(route = AppScreens.Ejercicio_4.route){
            Ejercicio_4(navController)
        }
        composable(route = AppScreens.Ejercicio_5.route){
            Ejercicio_5(navController)
        }
    }
}