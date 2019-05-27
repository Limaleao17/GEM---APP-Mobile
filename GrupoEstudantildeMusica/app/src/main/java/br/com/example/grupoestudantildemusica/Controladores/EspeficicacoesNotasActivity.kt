package br.com.example.grupoestudantildemusica.Controladores

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.example.grupoestudantildemusica.R

class EspeficicacoesNotasActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_espeficicacoes_notas)

        supportActionBar?.title = "Descrição de sua atividade"

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.action_adicionar){
            Toast.makeText(context, "Botão adicionar", Toast.LENGTH_LONG).show()
            val  intent = Intent(context, CadastroContatosActivity::class.java)

        }

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
