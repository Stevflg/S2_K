package com.example.s2_k.Data

import kotlin.math.round


class IMC (){
    private var Weight: Double=0.0
    private var Height: Double=0.0
    constructor(Weight: Double,Height: Double):this(){
        this.Weight=Weight
        this.Height=Height
    }
    fun setDatos(Weight: Double,Height: Double){
        this.Weight=Weight
        this.Height=Height
    }
    fun Mostar_Resultado(): String{
        var IMC = Weight/(Height*2)
        return  "Su IMC es de ${round(IMC)}"
    }
}