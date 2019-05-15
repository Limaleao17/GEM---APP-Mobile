package br.com.example.grupoestudantildemusica.Controladores

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import br.com.example.grupoestudantildemusica.*
import br.com.example.grupoestudantildemusica.Adapter.ContatoAdapter
import br.com.example.grupoestudantildemusica.Models.Contatos
import br.com.example.grupoestudantildemusica.Service.ContatoProfessorService

class ContatoProfessoresListActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

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
                this.contatos =
                    ContatoProfessorService.getContatoProfessores(context)
                runOnUiThread {
                    recyclerContato?.adapter =
                        ContatoAdapter(contatos) {onClickContatos(it)
                        }

                   //enviaNotificacao(this.contatos.get(0))
                }
            }.start()

        }



    fun onClickContatos(contatos: Contatos){
        Toast.makeText(context, "Clicou ${contatos.nome}" ,Toast.LENGTH_SHORT).show()
        val intent = Intent (context, AjudaActivity::class.java)
        //intent.putExtra("contatos", contatos )
        startActivity(intent)
    }

    private fun configuraMenuLateral() {
        var toolbar = findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar)
        var menuLateral = findViewById<DrawerLayout>(R.id.layoutMenuLateral)

        var toogle = ActionBarDrawerToggle(
            this, menuLateral,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        menuLateral.addDrawerListener(toogle)
        toogle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.view_menu_lateral)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_notas -> {
                Toast.makeText(
                    this, "Consulte seu boletim",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, NotasActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_calandario -> {
                Toast.makeText(
                    this, "Consulte seu Calendario",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, CalendarioActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_faltas -> {
                Toast.makeText(
                    this, "Consulte suas faltas",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, FaltasActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_horario -> {
                Toast.makeText(
                    this, "Consulte seus horários",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, HorarioActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_manual_aluno -> {
                Toast.makeText(
                    this, "Consulte o Manual do aluno",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, ManualAlunoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_aulas_ministradas -> {
                Toast.makeText(
                    this, "Veja novamente o conteúdo de sua aula",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, AulasMinistradasActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_biblioteca -> {
                Toast.makeText(
                    this, "Consulta de livros",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, BibliotecaActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_contato_professores -> {
                Toast.makeText(this, "Verifique o contato de seu professor", Toast.LENGTH_SHORT)
                intent = Intent (this, ContatoProfessoresListActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_ouvidoria -> {
                Toast.makeText(
                    this, "Sugestão ou reclamação",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, OuvidoriaActivity::class.java)
                startActivity(intent)
            }
        }

        val drawer = findViewById<DrawerLayout>(R.id.layoutMenuLateral)
        drawer.closeDrawer(GravityCompat.START)
        return true

    }




    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.action_adicionar){
            Toast.makeText(context, "Botão adicionar", Toast.LENGTH_LONG).show()
            val  intent = Intent(context, CadastroContatosActivity::class.java)
            startActivityForResult(intent, REQUEST_CADASTRO)
        }

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
