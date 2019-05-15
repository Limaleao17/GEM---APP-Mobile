package br.com.example.grupoestudantildemusica.Database

import android.arch.persistence.room.Room
import br.com.example.grupoestudantildemusica.Utils.GEMApplication

object DatabaseManager {
    private var dbIntance: GEMDatabase

    init{
        val appContext = GEMApplication.getInstance().applicationContext
        dbIntance = Room.databaseBuilder(
            appContext,
            GEMDatabase::class.java,
            "gem.sqlite"
        ).build()
    }

    fun getContatoDAO(): ContatosDAO {
        return dbIntance.contatoDao()
    }
}