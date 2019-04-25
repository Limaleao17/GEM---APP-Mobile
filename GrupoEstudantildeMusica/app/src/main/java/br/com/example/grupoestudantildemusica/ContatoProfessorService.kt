package br.com.example.grupoestudantildemusica

import android.content.Context
import android.util.Log
import java.net.URL

object ContatoProfessorService {

    val host = "http://localhost:5000/contatos"
    val TAG = "WS_GEM"

    //fun getDisciplinas(context: Context): List<Contatos> {

        //val url = "$host/contatos"
        //val json = URL(url).readText()
       // Log.d(TAG, json)
        //return parserJson<List<Contatos>>(json)

    //}

    //inline fun <reified T> parserJson(json: String): T {
        //val type = object: TypeToken<T>(){}.type
        //return Gson().fromJson<T>(json, type)
    //}
}

    fun getContatoProfessores(context: Context) : List<Contatos> {
        val contatos = mutableListOf<Contatos>()
        for (i in 1..10) {
            val c = Contatos()
            c.nome = "Contatos $i"
            c.foto = "https://musicasemlimites.com/wp-content/uploads/2016/02/prof1.jpg"
            contatos.add(c)
        }
        return contatos
    }
