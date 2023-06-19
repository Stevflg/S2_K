package com.example.s2_k.Data

class Empleado() {
    private var Name: String = ""
    private var Surname: String =""

    constructor(Name:String, Surname:String,Age: Int):this(){
        this.Name=Name
        this.Surname=Surname
    }
    fun GetName(): String {
        return Name
    }
    fun SetName(Name:String){
        this.Name=Name
    }
    fun GetSurName(): String {
        return Surname
    }
    fun SetSurName(Surname: String){
        this.Surname=Surname
    }
    fun Mostrar():String{
            return "Nombre: $Name \nApellido: $Surname"
    }
}