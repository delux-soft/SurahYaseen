package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.interfaces.AdListener
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd


private const val TAG = "MyAppOpenAdXX"

class MyAppOpenAd(
    private val application: Application
) : LifecycleEventObserver, Application.ActivityLifecycleCallbacks {

    private var adIdLow: String

    //    private var adIdMed: String
    private lateinit var activity: Activity


    private var isLoading = false
    private var isShowingAd = false
    var wantToShow = false
    private var appOpenAd: AppOpenAd? = null


    init {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        application.registerActivityLifecycleCallbacks(this)
        adIdLow = application.getString(string.low_app_open_id)
//        adIdMed = application.getString(R.string.med_app_open_id)

    }


    private fun fetchAd() {

        Log.d(TAG, "fetchAd: ${!isLoading} $appOpenAd")
        if (!isLoading && appOpenAd == null) {

            val adRequest = AdRequest.Builder().build()
            isLoading = true
            val callback = object :
                AppOpenAd.AppOpenAdLoadCallback() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.d(TAG, "fetchAd: onAdFailedToLoad ${p0.message}")
                    isLoading = false

                }

                override fun onAdLoaded(p0: AppOpenAd) {
                    super.onAdLoaded(p0)
                    Log.d(TAG, "Successfully Loaded")
                    isLoading = false
                    appOpenAd = p0

                }
            }
            AppOpenAd.load(
                application,
                adIdLow,
                adRequest,
                callback
            )


        }

    }


    fun showAdRightNow(listener: AdListener) {
        if (appOpenAd != null && !isShowingAd) {

            val callback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()

                    listener.onAdDismissed()
                    appOpenAd = null
                    isShowingAd = false
                    fetchAd()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)

                    isShowingAd = false
                    listener.onAdShowingFailed()
                }

            }

            isShowingAd = true
            appOpenAd?.fullScreenContentCallback = callback
            appOpenAd?.show(activity)
        } else {
            Log.d(TAG, "showAdRightNow:  null")
            listener.onAdNull()
            fetchAd()
        }
    }

    private fun showAd() {
        if (appOpenAd != null && wantToShow && !isShowingAd) {
            Log.d(TAG, "showAd: show")
            val callback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    appOpenAd = null
                    isShowingAd = false
                    fetchAd()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)

                    isShowingAd = false
                }

            }

            isShowingAd = true
            appOpenAd?.fullScreenContentCallback = callback
            appOpenAd?.show(activity)
        } else {
            Log.d(TAG, "showAd: else")
            fetchAd()
        }
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {

        if (event == Lifecycle.Event.ON_START) {
            Log.d(TAG, "onStateChanged: ")
            showAd()
        }
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        // Activity Create
    }

    override fun onActivityStarted(p0: Activity) {
        if (!isShowingAd) {
            activity = p0
        }
    }

    override fun onActivityResumed(p0: Activity) {
        // Activity Resume
    }

    override fun onActivityPaused(p0: Activity) {
        // Activity Pause
    }

    override fun onActivityStopped(p0: Activity) {
        // Activity Stop
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        // Activity SavedInstance
    }

    override fun onActivityDestroyed(p0: Activity) {
        // Activity Destroyed
    }

}