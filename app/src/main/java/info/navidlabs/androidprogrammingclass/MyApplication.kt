package info.navidlabs.androidprogrammingclass

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("Notification", "created application")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("Notification", "notification channel created")

            val channel = NotificationChannel(
                "service_channel",
                "My Notification",
                NotificationManager.IMPORTANCE_HIGH
            )

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}