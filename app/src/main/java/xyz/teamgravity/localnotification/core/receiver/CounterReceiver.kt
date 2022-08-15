package xyz.teamgravity.localnotification.core.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.localnotification.core.notification.CounterNotification
import javax.inject.Inject

@AndroidEntryPoint
class CounterReceiver : BroadcastReceiver() {

    @Inject
    lateinit var notification: CounterNotification

    override fun onReceive(context: Context?, intent: Intent?) {
        notification.count++
        notification.show()
    }
}