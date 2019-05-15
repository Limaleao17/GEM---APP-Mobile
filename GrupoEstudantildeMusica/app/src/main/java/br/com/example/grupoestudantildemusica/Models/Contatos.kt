package br.com.example.grupoestudantildemusica.Models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import com.google.gson.GsonBuilder

@Entity(tableName = "contatos")
class Contatos {

        @PrimaryKey
        var id:Long = 0
        var nome = ""
        var endereco = ""
        var materia = ""

        override fun toString(): String {
            return "Contatos: $nome Endereco: $endereco Materia: $materia"

        }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}