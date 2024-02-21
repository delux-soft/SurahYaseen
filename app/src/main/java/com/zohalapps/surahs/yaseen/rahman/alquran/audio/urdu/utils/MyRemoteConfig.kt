package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.R

private const val TAG = "MyAdsRemoteConfigXX"

private const val SHOW_INTERSTITIAL = "show_interstitial_ad"
private const val SHOW_NATIVE_AD = "show_native_ad"
private const val SHOW_INLINE_BANNER = "show_inline_banner_ad"
private const val SHOW_MED_APP_OPEN = "show_med_app_open"
private const val SHOW_LOW_APP_OPEN = "show_low_app_open"

private const val INTER_AD_TIME = "inter_ad_time"

object MyRemoteConfig {


    var showInterstitialAd = false
    var showInlineBanner = false
    var showNativeAd = false
    var showMedAppOpen = false

    var showLowAppOpen = false
    var requiredTime = 0L

    fun init(callback: () -> Unit) {
        val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
            fetchTimeoutInSeconds = 3L
            build()
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_default)


        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {

                showInterstitialAd = remoteConfig.getBoolean(SHOW_INTERSTITIAL)
                showNativeAd = remoteConfig.getBoolean(SHOW_NATIVE_AD)
                showInlineBanner = remoteConfig.getBoolean(SHOW_INLINE_BANNER)
                showMedAppOpen = remoteConfig.getBoolean(SHOW_MED_APP_OPEN)
                showLowAppOpen = remoteConfig.getBoolean(SHOW_LOW_APP_OPEN)
                requiredTime = remoteConfig.getLong(INTER_AD_TIME)
                Log.d(TAG, "init success: $showMedAppOpen")
                callback()
            } else {
                callback()
            }
        }


        remoteConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
            override fun onUpdate(configUpdate: ConfigUpdate) {
                if (configUpdate.updatedKeys.contains(SHOW_INTERSTITIAL)) {
                    remoteConfig.activate().addOnCompleteListener {
                        showInterstitialAd = remoteConfig.getBoolean(SHOW_INTERSTITIAL)
                    }
                }
                if (configUpdate.updatedKeys.contains(SHOW_INLINE_BANNER)) {
                    remoteConfig.activate().addOnCompleteListener {
                        showInlineBanner = remoteConfig.getBoolean(SHOW_INLINE_BANNER)
                    }
                }
                if (configUpdate.updatedKeys.contains(SHOW_MED_APP_OPEN)) {
                    remoteConfig.activate().addOnCompleteListener {
                        showMedAppOpen = remoteConfig.getBoolean(SHOW_MED_APP_OPEN)

                    }
                }
                if (configUpdate.updatedKeys.contains(SHOW_LOW_APP_OPEN)) {
                    remoteConfig.activate().addOnCompleteListener {
                        showLowAppOpen = remoteConfig.getBoolean(SHOW_LOW_APP_OPEN)
                    }
                }

                if (configUpdate.updatedKeys.contains(SHOW_NATIVE_AD)) {
                    remoteConfig.activate().addOnCompleteListener {
                        showNativeAd = remoteConfig.getBoolean(SHOW_NATIVE_AD)
                    }
                }

                if (configUpdate.updatedKeys.contains(INTER_AD_TIME)) {
                    remoteConfig.activate().addOnCompleteListener {
                        requiredTime = remoteConfig.getLong(INTER_AD_TIME)
                    }
                }
            }

            override fun onError(error: FirebaseRemoteConfigException) {
                Log.d(TAG, "onError: ${error.message}")
            }

        })
    }
}