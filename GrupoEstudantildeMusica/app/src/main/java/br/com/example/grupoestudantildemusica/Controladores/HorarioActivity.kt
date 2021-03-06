package br.com.example.grupoestudantildemusica.Controladores

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import br.com.example.grupoestudantildemusica.R
import kotlinx.android.synthetic.main.activity_horario.*
import kotlinx.android.synthetic.main.activity_notas.*

class HorarioActivity : AppCompatActivity() {

    private val context: Context get() = this
    lateinit var listaAtividades: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horario)


        supportActionBar?.title = "Horário"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}

