package br.com.example.grupoestudantildemusica.Controladores

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.example.grupoestudantildemusica.R

class SobreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        supportActionBar?.title = "Sobre"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.ajuda) {
            Toast.makeText(this, "Ajuda", Toast.LENGTH_LONG).show()
            intent = Intent (this, SobreActivity::class.java)
            startActivity(intent)

        } else if (id == R.id.sobre) {
            Toast.makeText(this, "Sobre", Toast.LENGTH_LONG).show()
            intent = Intent (this, SobreActivity::class.java)
            startActivity(intent)
        }
        else if(id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
