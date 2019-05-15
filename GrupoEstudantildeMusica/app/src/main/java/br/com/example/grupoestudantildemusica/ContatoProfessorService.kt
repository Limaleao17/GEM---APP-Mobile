package br.com.example.grupoestudantildemusica

import android.content.Context
import android.util.Log
import br.com.example.grupoestudantildemusica.AndroidUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.net.URL

object ContatoProfessorService {

    val host = "localhost/5000"
    val TAG = "WS_GEM"

    fun getContatoProfessores(context: Context): List<Contatos> {
      //  val contatos = mutableListOf<Contatos>()
        //for (i in 1..10) {
          //  val d = Contatos()
            //d.nome = "Contatos $i"
            //d.endereco = "Endereco $i"
            //d.materia = "Materia $i"
            //d.foto = "https://musicasemlimites.com/wp-content/uploads/2016/02/prof1.jpg"
            //contatos.add(d)

        //}
        //return contatos
    //}

        if (AndroidUtils.isInternetDisponivel(context)) {
            var contatos = ArrayList<Contatos>()
            val url = "$host/contatos"
            val json = HttpHelper.get(url)
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

    fun getContato (context: Context, id: Long): Contatos?{
        if (AndroidUtils.isInternetDisponivel(context)){
            val url = "$host/contatos/${id}"
            val json = HttpHelper.get(url)
            val contatos = parserJson<Contatos>(json)

            return contatos
        }
        else{
            val dao = DatabaseManager.getContatoDAO()
            val contatos = dao.getById(id)
            return contatos
        }
    }

    fun save(contatos: Contatos) : Response{
        val json = HttpHelper.post("$host/contatos", contatos.toJson())
        return parserJson(json)
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

}