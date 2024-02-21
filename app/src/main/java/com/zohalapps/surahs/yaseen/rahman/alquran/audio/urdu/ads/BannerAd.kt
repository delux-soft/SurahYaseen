package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.google.android.gms.ads.*

class BannerAd(val context: Context, mLifeCycle: Lifecycle) : DefaultLifecycleObserver {

    private var loading = false
    private var adView: AdView? = null

    init {
        mLifeCycle.addObserver(this)
    }

    fun loadBanner(callback: (AdView) -> Unit) {
        if (loading || adView != null)
            return
        adView = AdView(context).apply {
            setAdSize(getSizeOfAd())
            adUnitId = context.getString(string.banner_id)
            adListener = object : AdListener() {
                override fun onAdLoaded() {
                    super.onAdLoaded()
                    loading = false
                    callback.invoke(adView!!)
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    loading = false
                    adView = null
                }
            }
        }
        adView?.loadAd(AdRequest.Builder().build())
        loading = true
    }

    private fun getSizeOfAd(): AdSize {
        val metrics = context.resources.displayMetrics
        val densityAdjustment = if (metrics.density > 1) (1.0 / metrics.density) else 1.0
        val width = (metrics.widthPixels * densityAdjustment).toInt()
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, width)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        adView?.resume()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        adView?.pause()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        adView?.destroy()
    }
}