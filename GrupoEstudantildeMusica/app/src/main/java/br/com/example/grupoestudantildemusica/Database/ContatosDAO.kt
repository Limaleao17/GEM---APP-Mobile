package br.com.example.grupoestudantildemusica.Database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.com.example.grupoestudantildemusica.Models.Contatos

@Dao
interface ContatosDAO {

    @Query("SELECT * FROM contatos where id = :id")
    fun getById(id: Long) : Contatos?

    @Query("SELECT * FROM Contatos")
    fun findAll() : List<Contatos>

    @Insert
    fun insert(contatos: Contatos)

    @Delete
    fun delete(contatos: Contatos)
}