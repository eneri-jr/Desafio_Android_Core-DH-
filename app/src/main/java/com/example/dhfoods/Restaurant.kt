package com.example.dhfoods

class Restaurant(val id: Int, var img: Int, var nome: String, var end: String, var horario: String){

    override fun toString(): String {
        return "Restaurant(id=$id, img=$img, nome='$nome', end='$end', hoario='$horario')"
    }
}