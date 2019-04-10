package br.com.example.grupoestudantildemusica

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)


        btn_login.setOnClickListener() {

            if(et_email.text.toString().equals("Aluno")
                && et_password.text.toString().equals("Impacta")) {
                intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
