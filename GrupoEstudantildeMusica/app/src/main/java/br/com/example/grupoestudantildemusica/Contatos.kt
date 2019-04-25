package br.com.example.grupoestudantildemusica

import android.content.Context

class Contatos {

        var id:Long = 0
        var nome = ""
        var foto = ""

        override fun toString(): String {
            return "Contatos: $nome"
        }

    }