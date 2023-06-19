package com.example.s2_k.Data

class Triangulo(){
    private var lado1: Int=0
    private var lado2: Int=0
    private var lado3: Int=0
    fun CargarDatos(lado1: Int,lado2: Int, lado3: Int){
        this.lado1=lado1
        this.lado2=lado2
        this.lado3=lado3
    }
    fun lado_mayor(): String{
        if (lado1>lado2 && lado1>lado3){
        return "El lado mayor es el lado 1 : ${lado1.toString()}"
    }
        if (lado2>lado3&& lado2>lado1){
        return "El lado mayor es el lado 2 : ${lado2.toString()}"
    }
        if(lado1==lado2||lado1==lado3){
        return "Hay lados con la misma medida"
        }
        return "El lado mayor es el lado 3 : ${lado3.toString()}"
    }

    fun comprobar(): String{
        if(lado1==lado2 && lado3==lado1){
            return "El triangulo es equilatero"
        }
        else   {
            return "El triangulo no es equilatero"
        }
    }
}