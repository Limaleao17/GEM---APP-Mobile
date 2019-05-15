package br.com.example.grupoestudantildemusica

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.support.v7.widget.Toolbar


class TelaInicialActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = "GEM"

        configuraMenuLateral()
    }

    private fun configuraMenuLateral() {
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var menuLateral = findViewById<DrawerLayout>(R.id.layoutMenuLateral)

        var toogle = ActionBarDrawerToggle(
            this, menuLateral,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

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
                Toast.makeText(
                    this, "Verifique o contato de seu professor",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, ContatoProfessoresActivity::class.java)
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

    fun cliqueSair(){
        val retunrIntent = Intent();
        retunrIntent.putExtra("result","Saída do App")
        setResult(Activity.RESULT_OK, retunrIntent);
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.ajuda) {
            Toast.makeText(this, "Ajuda", Toast.LENGTH_LONG).show()
            intent = Intent (this, AjudaActivity::class.java)
            startActivity(intent)

        } else if (id == R.id.sobre) {
            Toast.makeText(this, "Sobre", Toast.LENGTH_LONG).show()
            intent = Intent (this, SobreActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    fun enviaNotificacao(){
        val intent = Intent(this, ContatoProfessoresActivity::class.java)
        NotificationUtil.create(1, intent,
            "GEM", "Mensagem nova")
    }
}




