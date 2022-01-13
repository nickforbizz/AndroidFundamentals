package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_notifications.*

class NotificationActivity : AppCompatActivity() {

    val channel_ID = "channelId"
    val channel_Name = "channelName"
    val Notification_ID = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        createNotificationChannel()

        val intent = Intent(this,NotificationActivity::class.java)
        val pendingItent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_CANCEL_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, channel_ID)
            .setContentTitle("This my notification in an app, woooho")
            .setContentText("This is my first time doing this")
            .setSmallIcon(R.drawable.ic_home)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingItent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        btnNotification.setOnClickListener {

            notificationManager.notify(Notification_ID, notification)
        }
    }


    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channel_ID, channel_Name,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // manage behavior of notification
                //lightColor = color.
                //enableLights(true)
            }

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

        }
    }
}