package com.example.s2_k.navigation




sealed class AppScreens(val route: String){
        object Main: AppScreens("main")
        object Ejercicio_1: AppScreens("ejercicio_1")
        object Ejercicio_2: AppScreens("ejercicio_2")
        object Ejercicio_3: AppScreens("ejercicio_3")
        object Ejercicio_4: AppScreens("ejercicio_4")
        object Ejercicio_5: AppScreens("ejercicio_5")

}
