package com.example.surahyaseen.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.surahyaseen.model.CalenderResponseModel
import com.example.surahyaseen.utils.GenericResult

class CalenderRepo {

    private val mutableLiveData = MutableLiveData<GenericResult<CalenderResponseModel>>()

    val liveData: LiveData<GenericResult<CalenderResponseModel>> get() = mutableLiveData




    suspend fun getCalenderData() {

    }
}