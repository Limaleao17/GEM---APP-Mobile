package br.com.example.grupoestudantildemusica.Controladores

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import br.com.example.grupoestudantildemusica.Models.Contatos
import br.com.example.grupoestudantildemusica.R

class ContatoActivity : AppCompatActivity() {

    var contatos: Contatos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)

        contatos = intent.getSerializableExtra("contato") as Contatos

        var toolbar =findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = contatos?.nome

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var texto = findViewById<TextView>(R.id.nomeProfessor)
        texto.text = contatos?.nome
        var imagem = findViewById<ImageView>(R.id.image)
    }
}
