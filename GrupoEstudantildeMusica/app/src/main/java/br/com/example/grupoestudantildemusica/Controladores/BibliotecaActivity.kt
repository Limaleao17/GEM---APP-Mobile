package br.com.example.grupoestudantildemusica.Controladores

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import br.com.example.grupoestudantildemusica.Adapter.Custom_Adapter
import br.com.example.grupoestudantildemusica.R

class BibliotecaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)

        supportActionBar?.title = "Biblioteca"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val GV = this.findViewById(R.id.gridV) as GridView
        val adapter = Custom_Adapter(this, R.layout.customlayout, data)

        GV.adapter = adapter


    }


        val data: ArrayList<Customlayout>
        get()
        {
            val item_liste : ArrayList<Customlayout> = ArrayList<Customlayout>()

            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))
            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))
            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))
            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))
            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))
            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))
            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))
            item_liste.add(Customlayout(R.drawable.logo_gem, "Livro O cantigo das sanfonas"))

            return item_liste

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
