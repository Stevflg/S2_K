package com.example.s2_k.Data

class Persona (){

    private var Name: String = ""
    private var Surname: String =""
    private var Age: Int=0

    constructor(Name:String, Surname:String,Age: Int):this(){
        this.Name=Name
        this.Surname=Surname
        this.Age=Age
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
    fun GetAge(): Int {
        return Age
    }
    fun SetAge(Age: Int){
        this.Age=Age
    }
    fun Mostrar():String{
        if(Age>18){
            return "Nombre: $Name \nApellido: $Surname \nEdad: ${Age.toString()} \n" +
                    "Usted es Mayor de edad"
        }
        else{
            return "Nombre: $Name \nApellido: $Surname \nEdad: ${Age.toString()} \n" +
                    "Usted es Menor de edad"
        }
    }
}