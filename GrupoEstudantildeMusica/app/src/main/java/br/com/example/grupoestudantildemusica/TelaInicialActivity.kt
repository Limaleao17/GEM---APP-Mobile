package br.com.example.grupoestudantildemusica

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import android.R.id.toggle



class TelaInicialActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        supportActionBar?.title = "GEM"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
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
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_boletim -> {
                Toast.makeText(
                    this, "Veja seu boletim",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, BoletimActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_calendario -> {
                Toast.makeText(
                    this, "Veja seu Calendario",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, CalendarioActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_dados_pessoais -> {
                Toast.makeText(
                    this, "Atualize seus dados pessoais",
                    Toast.LENGTH_SHORT
                )
                intent = Intent (this, DadosPessoaisActivity::class.java)
                startActivity(intent)
            }
        }

        val drawer = findViewById<DrawerLayout>(R.id.layoutMenuLateral)
        drawer.closeDrawer(GravityCompat.START)
        return true

    }
    private fun configuraMenuLateral() {
        var menuLateral = findViewById<DrawerLayout>(R.id.layoutMenuLateral)

        var toogle = ActionBarDrawerToggle(
            this, menuLateral,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

        menuLateral.addDrawerListener(toogle)
        toogle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.view_menu_lateral)
        navigationView.setNavigationItemSelectedListener(this)
    }

}




