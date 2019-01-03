package joyfunee.procounter.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews
import joyfunee.procounter.R

class DateChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        loadPreferences()
    }

    private fun loadPreferences() {
    }

    private val CHANNEL_ID: String = "channel id"

    private fun sendNotification(id: Int, content: String, context: Context) {
        var remoteView = RemoteViews(context.packageName, R.layout.layout_notification)

        var notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setContentTitle("textTitle")
            .setContentText(content).setCustomContentView(remoteView)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

        (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(id, notification)
    }
}