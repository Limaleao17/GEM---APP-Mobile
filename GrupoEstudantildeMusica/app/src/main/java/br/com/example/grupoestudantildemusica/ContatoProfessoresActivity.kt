package br.com.example.grupoestudantildemusica

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ContatoProfessoresActivity : AppCompatActivity() {

    private val context: Context get() = this

    private var contatos = listOf<Contatos>()
    var recyclerContato: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_professores)

        supportActionBar?.title = "Contato dos professores"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerContato = findViewById<RecyclerView>(R.id.recyclerContato)
        recyclerContato?.layoutManager = LinearLayoutManager(context)
        recyclerContato?.itemAnimator = DefaultItemAnimator()
        recyclerContato?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskContatos()
    }

    fun taskContatos() {
        Thread {
            this.contatos = ContatoProfessorService.getDisciplinas(context)
            recyclerContato?.adapter = ContatoAdapter (contatos){
                onClickContatos(it)
            }
        }.start()
    }

    fun onClickContatos(contatos: Contatos){
        Toast.makeText(context, "Clicou ${contatos.nome}" ,
            Toast.LENGTH_SHORT).show()
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
