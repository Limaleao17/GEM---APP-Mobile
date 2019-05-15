package br.com.example.grupoestudantildemusica.Controladores

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.example.grupoestudantildemusica.Utils.Prefs
import br.com.example.grupoestudantildemusica.R
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)





        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            val lembrarNome = Prefs.getString("lembrarNome")
            val lembrarSenha = Prefs.getString("lembrarSenha")
            et_email.setText(lembrarNome)
            et_password.setText(lembrarSenha)
            checkbox.isChecked = lembrar
        }

        btn_login.setOnClickListener { onClickLogin() }

    }

        fun onClickLogin() {

            val valorUsuario = et_email.text.toString()
            val valorSenha = et_password.text.toString()

            if (valorUsuario == "aluno" && valorSenha == "Impacta") {
                Prefs.setBoolean("lembrar", checkbox.isChecked)
                if (checkbox.isChecked) {
                    Prefs.setString("lembrarNome", valorUsuario)
                    Prefs.setString("lembrarSenha", valorSenha)
                } else {
                    Prefs.setString("lembrarNome", "")
                    Prefs.setString("lembrarSenha", "")
                }

                val intent = Intent(context, TelaInicialActivity::class.java)

                val params = Bundle()
                params.putString("nome", valorUsuario)

                intent.putExtras(params)

                startActivityForResult(intent, 1)
            }
            else{
                Toast.makeText(context, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show()
            }
        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }
}

