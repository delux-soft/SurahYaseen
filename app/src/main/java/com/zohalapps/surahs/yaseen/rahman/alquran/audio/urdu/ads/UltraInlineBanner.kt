package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads

import android.content.Context
import android.util.Log
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.MyRemoteConfig

import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

private const val TAG = "UltraInlineBanner"
object UltraInlineBanner {

    private var isLoaded = true
    private var adView: AdView? = null



    fun loadBanner(context: Context,callback: (AdView) -> Unit){


        if (!MyRemoteConfig.showInlineBanner)
            return

        if (adView != null){
            callback(adView!!)
            return
        }

        adView = AdView(context).apply {
            setAdSize(AdSize.MEDIUM_RECTANGLE)
            adUnitId = context.getString(string.inline_banner_id)
            adListener = object : AdListener(){
                override fun onAdLoaded() {
                    super.onAdLoaded()
                    Log.d(TAG, "onAdLoaded: ")
                    if (isLoaded){
                        isLoaded = false
                        callback.invoke(adView!!)
                    }
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.d(TAG, "onAdFailedToLoad: ${p0.message} $width")
                }
            }
        }



        adView?.loadAd(AdRequest.Builder().build())

    }
}