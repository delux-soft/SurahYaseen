package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.app

import android.app.Application
import android.os.StrictMode
import android.util.Log
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.MyAppOpenAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.interfaces.AdListener
import com.google.android.gms.ads.MobileAds
import com.google.firebase.BuildConfig
import com.google.firebase.messaging.FirebaseMessaging


private const val TAG = "MyApplicationXX"
class MyApplication : Application() {

    private var myAppOpenAd: MyAppOpenAd? = null
    var count = 0
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
        myAppOpenAd = MyAppOpenAd(this)
        if (BuildConfig.DEBUG) {

            FirebaseMessaging.getInstance().subscribeToTopic("bg_yaseen_test").addOnSuccessListener {
                Log.d(TAG, "onCreate: done")
            }
                .addOnFailureListener {
                    Log.d(TAG, "onCreate: ${it.message}")
                }
        } else {
            FirebaseMessaging.getInstance().subscribeToTopic("bg_yaseen").addOnSuccessListener {
                Log.d(TAG, "onCreate: done")
            }
                .addOnFailureListener {
                    Log.d(TAG, "onCreate: ${it.message}")
                }
        }


    }

    private fun enableStrictMode() {
        val threadPolicy = StrictMode.ThreadPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build()
        val vmPolicy = StrictMode.VmPolicy.Builder()
            .detectLeakedSqlLiteObjects()
            .detectLeakedClosableObjects()
            .penaltyLog()
            .penaltyDeath()
            .build()
        StrictMode.setThreadPolicy(threadPolicy)
        StrictMode.setVmPolicy(vmPolicy)
    }


    fun notShowAppOpenAd() {
        myAppOpenAd?.wantToShow = false
    }

    fun showAppOpenAd() {
        myAppOpenAd?.wantToShow = true
    }

    fun showAdRightNow(listener: AdListener) {
        myAppOpenAd?.showAdRightNow(listener)
    }
}