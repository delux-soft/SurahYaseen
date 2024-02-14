package com.example.surahyaseen.viewModel

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.surahyaseen.model.Azimuth

class CompassVM : ViewModel() {

    val azimuth = MutableLiveData<Azimuth>()

    val trueNorth = MutableLiveData(false)
    val location = MutableLiveData<Location>()
}