package com.example.dhfoods

import java.io.Serializable

class Menu (val id: Int, var img: Int, var nome1: String, var nome2: String): Serializable {

    override fun toString(): String {
        return "Menu(id=$id, img=$img, nome1='$nome1', nome2='$nome2')"
    }
}