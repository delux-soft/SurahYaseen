package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads

import android.app.Application
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.MyRemoteConfig
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
object MyInterstitialAd {
    var mInterstitialAd: InterstitialAd? = null
    private var isLoading = false


    fun createAd(context: Application?) {

        loadAd(context)
    }

    private fun loadAd(context: Application?) {

        if (!isLoading && mInterstitialAd == null && context != null && MyRemoteConfig.showInterstitialAd) {
            isLoading = true
            val adRequest = AdRequest.Builder().build()
            InterstitialAd.load(
               context, context.getString(string.interstitial_id), adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                        isLoading = false
                        setCallback(context)


                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        isLoading = false
                        mInterstitialAd = null

                    }
                })
        }
    }

    private fun setCallback(context: Application) {
        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {


            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                super.onAdFailedToShowFullScreenContent(p0)
                mInterstitialAd = null
            }

            override fun onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent()
                mInterstitialAd = null
                loadAd(context)
            }
        }
    }

}