package br.com.example.grupoestudantildemusica

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class AjudaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajuda)

        supportActionBar?.title = "Ajuda"

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
