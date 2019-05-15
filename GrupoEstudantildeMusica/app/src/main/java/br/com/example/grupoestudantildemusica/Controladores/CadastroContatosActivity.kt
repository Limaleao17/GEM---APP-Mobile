package br.com.example.grupoestudantildemusica.Controladores

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.example.grupoestudantildemusica.Service.ContatoProfessorService
import br.com.example.grupoestudantildemusica.Models.Contatos
import br.com.example.grupoestudantildemusica.R
import kotlinx.android.synthetic.main.activity_cadastro_contatos.*
import kotlinx.android.synthetic.main.activity_contato.*
import kotlinx.android.synthetic.main.adapter_contato_professores.*
import kotlinx.android.synthetic.main.adapter_contato_professores.cardEndereco
import kotlinx.android.synthetic.main.adapter_contato_professores.cardNome

class CadastroContatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contatos)
        setTitle("Novo contato")

        salvarContatos.setOnClickListener{
                val contatos = Contatos()
                contatos.nome = nomeProfessor.text.toString()
                contatos.endereco = endereçoProfessor.text.toString()
                contatos.materia = materiaProfessor.text.toString()

                taskAtualizar(contatos)
        }
    }

    private fun taskAtualizar(contatos: Contatos){
        Thread{
            ContatoProfessorService.save(contatos)
            kotlin.run {
                finish()
            }
        }.start()
    }
}
