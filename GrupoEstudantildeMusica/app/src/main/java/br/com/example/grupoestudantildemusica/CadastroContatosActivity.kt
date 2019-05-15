package br.com.example.grupoestudantildemusica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_contatos.*
import kotlinx.android.synthetic.main.adapter_contato_professores.*

class CadastroContatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contatos)
        setTitle("Novo contato")

        salvarContatos.setOnClickListener{
                val contatos = Contatos()
                contatos.nome = cardNome.text.toString()
                contatos.endereco = cardEndereco.text.toString()
                contatos.materia = cardMateria.text.toString()
                contatos.foto = urlFoto.text.toString()

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
