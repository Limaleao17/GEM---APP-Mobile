package br.com.example.grupoestudantildemusica

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)



        btn_login.setOnClickListener { onClickLogin() }

        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            val lembrarNome = Prefs.getString("lembrarNome")
            val lembrarSenha = Prefs.getString("lembrarSenha")
            et_email.setText(lembrarNome)
            et_password.setText(lembrarSenha)
            checkbox.isChecked = lembrar
        }

    }

        fun onClickLogin(){

            val valorUsuario = et_email.text.toString()
            val valorSenha = et_password.text.toString()


            Prefs.setBoolean("lembrar", checkbox.isChecked)
            if (checkbox.isChecked){
                Prefs.setString("lembraNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            }
            else{
                Prefs.setString("lmebrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

            val intent = Intent (context, TelaInicialActivity::class.java)
            intent.putExtra("numero", 10)
            startActivityForResult(intent, 1)
        }

    override fun onResume() {
        super.onResume()
        et_email.setText(Prefs.getString("lembrarNome"))
        et_password.setText(Prefs.getString("lembrarSenha"))
        checkbox.isChecked = Prefs.getBoolean("lembrar")
    }
}

