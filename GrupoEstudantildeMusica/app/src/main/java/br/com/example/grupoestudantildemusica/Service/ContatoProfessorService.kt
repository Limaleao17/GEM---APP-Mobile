package br.com.example.grupoestudantildemusica.Service

import android.content.Context
import android.util.Log
import br.com.example.grupoestudantildemusica.Models.Contatos
import br.com.example.grupoestudantildemusica.Database.DatabaseManager
import br.com.example.grupoestudantildemusica.Service.ContatoProfessorService.host
import br.com.example.grupoestudantildemusica.Utils.HttpHelper
import br.com.example.grupoestudantildemusica.Utils.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ContatoProfessorService {

    val host = Host().host
    val TAG = "WS_GEM"

    fun getContatoProfessores(context: Context): List<Contatos> {
        var contatos = ArrayList<Contatos>()
         if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/contatos"
            val json = HttpHelper.get(url)
             Log.d(TAG, json)
            contatos = parserJson(json)
            for (d in contatos) {
                saveOffiline(d)
            }
            return contatos
        }
        else{
            val dao = DatabaseManager.getContatoDAO()
            val contatos = dao.findAll()
            return contatos
        }

    }
    fun save(contatos: Contatos) : Response {
        val json = HttpHelper.post("$host/contatos", contatos.toJson())
        return parserJson<Response>(json)
    }

    fun delete(contatos: Contatos): Response {
        if (AndroidUtils.isInternetDisponivel(GEMApplication.getInstance().applicationContext)) {
            val url = "$host/contatos/${contatos.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)

        } else {
            val dao = DatabaseManager.getContatoDAO()
            dao.delete(contatos)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }
    }


    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

    fun saveOffiline(contatos: Contatos) : Boolean {
        val dao = DatabaseManager.getContatoDAO()
        if (!existeContato(contatos)) {
          dao.insert(contatos)
        }
        return true
    }
    fun existeContato(contatos: Contatos): Boolean{
       val dao = DatabaseManager.getContatoDAO()
       return dao.getById(contatos.id) != null
    }


}
