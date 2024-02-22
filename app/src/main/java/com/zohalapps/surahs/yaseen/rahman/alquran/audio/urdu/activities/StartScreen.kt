package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.MyInterstitialAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.app.MyApplication
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.interfaces.AdListener
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.MyRemoteConfig
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils.NetConnectivity
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StartScreen : Activity() {
    private val binding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    private var wait = true

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val myApp by lazy {
        application as MyApplication
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        installSplashScreen().setKeepOnScreenCondition {
            wait
        }

        coroutineScope.launch {
            if (NetConnectivity.isOnline(this@StartScreen)) {
                val task = CompletableDeferred<Boolean>()
                MyRemoteConfig.init { task.complete(true) }
                task.await()
                wait = false
                withContext(Dispatchers.Main) {
                    MyInterstitialAd.createAd(application)
                    startTimer()
                }
            } else {
                delay(1000)
                withContext(Dispatchers.Main) {
                    changeScreen()
                }
            }
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val controller = window.insetsController
            controller?.hide(WindowInsets.Type.navigationBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    private fun startTimer() {


        val seconds = 8 * 1000L
        object : CountDownTimer(seconds, 1) {
            override fun onTick(millisUntilFinished: Long) {
                val finishedSeconds: Long = seconds - millisUntilFinished
                var total =
                    (finishedSeconds.toFloat() / seconds.toFloat() * 100.0).toInt()
                binding.progressBar.progress = ++total


            }

            override fun onFinish() {
                // DO something when 5 seconds is up

                myApp.showAdRightNow(object : AdListener {
                    override fun onAdDismissed() {
                        CoroutineScope(Dispatchers.Main).launch {
                            delay(1000)
                            changeScreen()
                        }
                    }

                    override fun onAdShowingFailed() {
                        changeScreen()
                    }

                    override fun onAdNull() {
                        changeScreen()
                    }

                })

            }
        }.start()


    }


    private fun changeScreen() {
        val intent = Intent(this@StartScreen, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}