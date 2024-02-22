package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fcm


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.FutureTarget
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.R
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.StartScreen
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.repo.Constants
import java.util.concurrent.ExecutionException


private const val TAG = "MyMessagingXX"

class MyMessaging : FirebaseMessagingService() {


    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        showNotification(message)
    }


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "onNewToken: ")
    }

    @Throws(ExecutionException::class, InterruptedException::class)
    private fun showNotification(message: RemoteMessage) {
        val intent: Intent
        val pkgName = message.data["packageName"]
        val imgUrl = message.data["image"]
        Log.d(
            TAG,
            "showNotification: " + message.data["title"] + " " + message.data["description"] + " " + message.data["image"]
        )
        val pkgNameToUse = pkgName ?: "" // Use empty string if pkgName is null
        val imgUrlToUse = imgUrl ?: ""

        if (pkgNameToUse.isEmpty()) {
            intent = Intent(this, StartScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        } else {
            intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$pkgNameToUse")
            )
        }
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val bitmap = if (imgUrlToUse.isEmpty()) {
            null
        } else {
            try {
                val futureTarget: FutureTarget<Bitmap> = Glide.with(this)
                    .asBitmap()
                    .load(imgUrl)
                    .submit()
                futureTarget.get()
            } catch (e: Exception) {
                Log.e(TAG, "showNotification: ${e.message}")
                e.printStackTrace()
                null
            }


        }
        val builder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.quran_icon)
                .setColor(ContextCompat.getColor(this, R.color.white))
                .setContentTitle(message.data["title"])
                .setContentText(message.data["body"])
                .setLargeIcon(bitmap)
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName: String = getString(R.string.app_name)
            val description = message.data["body"]
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(Constants.CHANNEL_ID, channelName, importance)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
            notificationManager.cancel(1)
        }
        notificationManager.notify(1, builder.build())
    }
}