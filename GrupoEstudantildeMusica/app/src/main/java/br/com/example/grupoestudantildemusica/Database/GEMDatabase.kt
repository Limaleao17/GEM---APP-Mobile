package br.com.example.grupoestudantildemusica.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.example.grupoestudantildemusica.Database.ContatosDAO
import br.com.example.grupoestudantildemusica.Models.Contatos

@Database(entities = arrayOf(Contatos::class), version = 1)
abstract class GEMDatabase: RoomDatabase() {
    abstract fun contatoDao() : ContatosDAO

}