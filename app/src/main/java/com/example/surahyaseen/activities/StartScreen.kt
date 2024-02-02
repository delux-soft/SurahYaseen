package com.example.surahyaseen.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartScreen : AppCompatActivity() {
    private val binding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        startTimer()
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

            }
        }.start()


    }
}