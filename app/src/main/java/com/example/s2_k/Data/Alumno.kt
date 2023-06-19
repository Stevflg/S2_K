package com.example.s2_k.Data

class Alumno() {
    private var Name:String = ""
    private var Surname: String = ""
    private var Score : Double = 0.0

    fun setName(Name: String){
        this.Name=Name
    }
    fun setSurname(Surname : String){
        this.Surname=Surname
    }
    fun setScore(Score: Double){
        this.Score=Score
    }

    fun Mostrar(): String{
        if(Score>=4){
        return "Hola $Name $Surname \nSu nota es Regular : $Score"
    }
        else{
            return "Hola $Name $Surname \nSu nota es  Pesima : $Score"
        }
    }
}