package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.R
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.app.MyApplication
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.ActivityMainBinding


typealias ID = R.id
typealias raw = R.raw
typealias string = R.string
typealias drawable = R.drawable


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val myApp by lazy {
        application as MyApplication
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }


    override fun onResume() {
        super.onResume()
        myApp.showAppOpenAd()
    }

    override fun onDestroy() {
        super.onDestroy()
        myApp.notShowAppOpenAd()
    }


}