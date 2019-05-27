package br.com.example.grupoestudantildemusica.Controladores

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.example.grupoestudantildemusica.R
import kotlinx.android.synthetic.main.activity_calendario.*
import java.util.*

class CalendarioActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        supportActionBar?.title = "Calendario"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnDate.setOnClickListener { onClickDate() }
    }
    
    fun onClickDate(){
        val intent = Intent (context, HorarioActivity::class.java)
        startActivity (intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if(id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    }




