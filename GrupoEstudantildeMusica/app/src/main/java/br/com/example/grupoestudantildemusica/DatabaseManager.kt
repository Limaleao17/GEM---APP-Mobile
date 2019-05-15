package br.com.example.grupoestudantildemusica

import android.arch.persistence.room.Room

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

    fun getContatoDAO(): ContatosDAO{
        return dbIntance.contatoDao()
    }
}