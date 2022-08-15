package xyz.teamgravity.localnotification.injection.provide

import android.app.Application
import android.app.NotificationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.teamgravity.localnotification.core.notification.CounterNotification
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideNotificationManager(application: Application): NotificationManager =
        application.getSystemService(NotificationManager::class.java)

    @Provides
    @Singleton
    fun provideCounterNotification(application: Application, notificationManager: NotificationManager): CounterNotification =
        CounterNotification(
            context = application,
            manager = notificationManager
        )
}