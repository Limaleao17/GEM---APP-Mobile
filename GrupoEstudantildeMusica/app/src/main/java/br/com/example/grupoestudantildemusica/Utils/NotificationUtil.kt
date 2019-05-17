package br.com.example.grupoestudantildemusica.Utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import br.com.example.grupoestudantildemusica.R

object NotificationUtil {

    internal val CHANNEL_ID = "1"

    fun createChannel(context: Context) {
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            val manager = GEMApplication.getInstance().applicationContext
                .getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager
            val appName = GEMApplication.getInstance().applicationContext
                .getString(R.string.app_name)

            val c = NotificationChannel(
                CHANNEL_ID, appName,
                NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(c)
        }

    }

    fun create(context: Context, id: Int, intent: Intent, titulo: String, texto:String) {
        createChannel(GEMApplication.getInstance())
        val context = GEMApplication.getInstance().applicationContext
        val p = PendingIntent.getActivity(context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context,
            CHANNEL_ID
        )
            .setContentIntent(p)
            .setContentTitle(titulo.toString())
            .setContentText(texto)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

        with(NotificationManagerCompat.from(GEMApplication.getInstance())){
            val n = builder.build()
            notify(id, n)
        }
    }
}