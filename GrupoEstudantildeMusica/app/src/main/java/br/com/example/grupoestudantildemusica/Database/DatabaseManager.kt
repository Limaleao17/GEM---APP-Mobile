package br.com.example.grupoestudantildemusica.Database

import android.arch.persistence.room.Room
import br.com.example.grupoestudantildemusica.Utils.GEMApplication

object DatabaseManager {
    private var dbIntanceContatos: GEMDatabase

    init{
        val appContext = GEMApplication.getInstance().applicationContext
        dbIntanceContatos = Room.databaseBuilder(
            appContext,
            GEMDatabase::class.java,
            "gem.sqlite"
        ).build()
    }

    fun getContatoDAO(): ContatosDAO {
        return dbIntanceContatos.contatoDao()
    }

}