package br.com.example.grupoestudantildemusica.Utils

import android.content.Intent
import android.util.Log
import br.com.example.grupoestudantildemusica.Controladores.ContatoProfessoresListActivity
import br.com.example.grupoestudantildemusica.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    val TAG = "firebase"

    // recebe o novo token criado
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "Novo token: $token")
        // Guarda o token em Shared Preferences
        Prefs.setString("FB_TOKEN", token!!)
}
    // recebe a notificação de push
    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")
// verifica se a mensagem recebida do firebase é uma notificação
        if (mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Titulo da mensagem: $titulo")
            Log.d(TAG, "Corpo da mensagem: $corpo")
            showNotification(mensagemRemota)
        }
    }

    private fun showNotification(mensagemRemota: RemoteMessage) {
// Intent para abrir quando clicar na notificação
        val intent = Intent(this, ContatoProfessoresListActivity::class.java)
            // se título for nulo, utilizar nome no app
        val titulo = mensagemRemota?.notification?.title?: getString(R.string.app_name)
        var mensagem = mensagemRemota?.notification?.body!!
        NotificationUtil.create(this, 1, intent, titulo, mensagem)
    }

}