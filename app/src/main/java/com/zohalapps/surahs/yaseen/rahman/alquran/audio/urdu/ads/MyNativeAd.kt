package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.MyRemoteConfig
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.AdUnifiedBinding


private const val TAG = "MyNativeAd"

object MyNativeAd {
    private var nativeAd: NativeAd? = null
    private var isLoading = false





    fun getNativeForHome(activity: Activity, callback: (NativeAdView) -> Unit) {
        if (nativeAd != null) {
            val unifiedBinding = AdUnifiedBinding.inflate(activity.layoutInflater)
            populateUnifiedNativeAdView(nativeAd!!, unifiedBinding)
            callback(unifiedBinding.root)
        } else {
            Log.d("POGO", "getNativeForHome: ${MyRemoteConfig.showNativeAd}")
            if (MyRemoteConfig.showNativeAd) {
                loadAd(activity) {
                    val unifiedBinding = AdUnifiedBinding.inflate(activity.layoutInflater)
                    populateUnifiedNativeAdView(nativeAd!!, unifiedBinding)
                    callback(unifiedBinding.root)
                }
            }

        }

    }


    private fun loadAd(context: Context, callback: (() -> Unit)?) {
        if (nativeAd == null && !isLoading) {
            Log.d(TAG, "loadAd: loading start")
            isLoading = true
            val builder = AdLoader.Builder(context, context.getString(string.native_ad))
            val videoOptions = VideoOptions.Builder()
                .setStartMuted(true)
                .build()
            val nativeAdOptions = NativeAdOptions.Builder().setVideoOptions(videoOptions).build()
            val adRequest = AdRequest.Builder().build()
            builder.forNativeAd { nativeAd: NativeAd? ->
                MyNativeAd.nativeAd = nativeAd
                isLoading = false
                Log.d(TAG, "loadAd: loaded")
                callback?.invoke()
            }
            builder.withAdListener(object : AdListener() {

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    super.onAdFailedToLoad(loadAdError)
                    nativeAd = null
                    isLoading = false
                    Log.d(TAG, "onAdFailedToLoad: failed")
                }

                override fun onAdImpression() {
                    super.onAdImpression()
                    nativeAd = null
                    isLoading = false
                    Log.d(TAG, "onAdImpression: showed")
                }

            })
            val adLoader = builder.withNativeAdOptions(nativeAdOptions).build()
            adLoader.loadAd(adRequest)
        }
    }



    private fun populateUnifiedNativeAdView(
        nativeAd: NativeAd,
        adUnifiedBinding: AdUnifiedBinding
    ) {
        val nativeAdView = adUnifiedBinding.root


        nativeAdView.mediaView = adUnifiedBinding.adMedia
        nativeAdView.iconView = adUnifiedBinding.adAppIcon
        nativeAdView.headlineView = adUnifiedBinding.tvad
        nativeAdView.starRatingView = adUnifiedBinding.adStars
        nativeAdView.callToActionView = adUnifiedBinding.adCallToAction

        adUnifiedBinding.adAdvertiser.text = nativeAd.headline
        nativeAd.mediaContent?.let {
            adUnifiedBinding.adMedia.mediaContent = it
        }


        if (nativeAd.callToAction == null) {
            adUnifiedBinding.adCallToAction.visibility = View.INVISIBLE
        } else {
            adUnifiedBinding.adCallToAction.visibility = View.VISIBLE
            adUnifiedBinding.adCallToAction.text = nativeAd.callToAction
        }

        if (nativeAd.icon == null) {
            adUnifiedBinding.adAppIcon.visibility = View.INVISIBLE
        } else {
            adUnifiedBinding.adAppIcon.visibility = View.VISIBLE
            adUnifiedBinding.adAppIcon.setImageDrawable(nativeAd.icon?.drawable)
        }


        if (nativeAd.starRating == null) {
            adUnifiedBinding.adStars.visibility = View.INVISIBLE
        } else {
            adUnifiedBinding.adStars.visibility = View.VISIBLE
            adUnifiedBinding.adStars.rating = nativeAd.starRating!!.toFloat()
        }


        nativeAdView.setNativeAd(nativeAd)

        val mediaContent = nativeAd.mediaContent
        val vc = mediaContent?.videoController

        if (vc != null && mediaContent.hasVideoContent()) {
            vc.videoLifecycleCallbacks =
                object : VideoController.VideoLifecycleCallbacks() {
                }
        }
    }
}