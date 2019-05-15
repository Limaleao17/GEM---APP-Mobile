package br.com.example.grupoestudantildemusica

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Contatos::class), version = 1)
abstract class GEMDatabase: RoomDatabase() {
    abstract fun contatoDao() : ContatosDAO

}