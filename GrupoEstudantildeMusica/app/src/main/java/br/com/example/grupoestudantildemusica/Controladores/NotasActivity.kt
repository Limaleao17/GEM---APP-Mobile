package br.com.example.grupoestudantildemusica.Controladores

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import br.com.example.grupoestudantildemusica.R

class NotasActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private val context: Context get() = this
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)


        supportActionBar?.title = "Boletim"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        listView = findViewById(R.id.listView)

        val notas = arrayOf("AC01", "AC02", "AC03", "AC04", "AC05")
        listView.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notas)

        listView.setOnItemClickListener{ adapterView, view, i, l ->
            Toast.makeText(applicationContext, "A nota de sua AC é " + notas[i], Toast.LENGTH_LONG).show()
            intent = Intent (this, EspeficicacoesNotasActivity::class.java)
            startActivity(intent)
        }


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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
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
