package com.hussien.tmdbshow.presentation.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.hussien.tmdbshow.presentation.movies.MoviesActivity

class NotificationUtils(
    private val context:Context
) {
    private val CHANNEL_ID = "com.hussien.tmdbshow.presentation.utils.CHANNEL1"
    private var notificationManager:NotificationManager? = null

    init {
        notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
    private fun createChannel(id:String,name:String,description:String){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(id,name,NotificationManager.IMPORTANCE_HIGH).apply {
                setDescription(description)
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }

    private fun displayNotification(title:String,description:String,icon:Int){
        val notificationId = 132
        val intent = Intent(context,MoviesActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,12,intent, FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(context,CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(icon)
            .setAutoCancel(true)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager?.notify(notificationId,notification)
    }
}