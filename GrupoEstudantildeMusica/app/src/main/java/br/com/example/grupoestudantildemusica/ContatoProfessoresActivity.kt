package br.com.example.grupoestudantildemusica

import android.content.Context
import android.content.Intent
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
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE = 2

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
                this.contatos = ContatoProfessorService.getContatoProfessores(context)
                runOnUiThread {
                    recyclerContato?.adapter = ContatoAdapter(this.contatos) {
                        onClickContatos(it)
                    }

                   // enviaNotificacao(this.contatos.get(0))
                }
            }.start()

        }

   fun enviaNotificacao(contatos: Contatos){
        val intent = Intent(this, AjudaActivity::class.java)
        NotificationUtil.create(this, 1, intent, "GEM", "Temos um novo proessor cadastrado em ${contatos.nome}")
    }

    fun onClickContatos(contatos: Contatos){
        Toast.makeText(context, "Clicou ${contatos.nome}" ,
             Toast.LENGTH_SHORT).show()
        val intent = Intent (context, AjudaActivity::class.java)
        //intent.putExtra("contatos", contatos )
        startActivity(intent)
     }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CADASTRO || requestCode == REQUEST_REMOVE ) {
            // atualizar lista de disciplinas
            taskContatos()
        }
    }
}
