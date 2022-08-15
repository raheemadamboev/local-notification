package xyz.teamgravity.localnotification.injection.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import xyz.teamgravity.localnotification.core.notification.CounterNotification
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var notification: CounterNotification

    override fun onCreate() {
        super.onCreate()

        notification.createChannel()
    }
}