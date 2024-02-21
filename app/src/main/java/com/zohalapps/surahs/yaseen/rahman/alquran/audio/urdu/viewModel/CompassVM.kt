package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.Azimuth

class CompassVM : ViewModel() {

    val azimuth = MutableLiveData<Azimuth>()

    val trueNorth = MutableLiveData(false)
    val location = MutableLiveData<Location>()
}