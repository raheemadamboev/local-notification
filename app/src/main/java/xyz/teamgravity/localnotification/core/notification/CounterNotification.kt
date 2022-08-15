package xyz.teamgravity.localnotification.core.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import xyz.teamgravity.localnotification.R
import xyz.teamgravity.localnotification.core.receiver.CounterReceiver
import xyz.teamgravity.localnotification.presentation.activity.Main

class CounterNotification(
    private val context: Context,
    private val manager: NotificationManager,
) {

    companion object {
        private const val CHANNEL_ID = "counter_channel"
        private const val NOTIFICATION_ID = 1
        private const val ACTIVITY_REQUEST_CODE = 1
        private const val INCREMENT_REQUEST_CODE = 2
    }

    var count: Int = 0

    fun show() {
        val activityIntent = PendingIntent.getActivity(
            context,
            ACTIVITY_REQUEST_CODE,
            Intent(context, Main::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            INCREMENT_REQUEST_CODE,
            Intent(context, CounterReceiver::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_clean)
            .setContentTitle(context.resources.getString(R.string.increment_counter))
            .setContentText(context.resources.getString(R.string.your_count, count.toString()))
            .setContentIntent(activityIntent)
            .addAction(R.drawable.ic_clean, context.getString(R.string.increment), incrementIntent)
            .build()

        manager.notify(NOTIFICATION_ID, notification)
    }

    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(CHANNEL_ID, context.getString(R.string.counter), NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = context.getString(R.string.increment_notifications)
                manager.createNotificationChannel(this)
            }
        }
    }
}