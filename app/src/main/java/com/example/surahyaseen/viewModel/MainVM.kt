package com.example.surahyaseen.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surahyaseen.model.SurahModel
import com.example.surahyaseen.repo.SurahRepo
import kotlinx.coroutines.launch

class MainVM : ViewModel() {
    private val surahRepo by lazy {
        SurahRepo()
    }


    private val mutableLiveData = MutableLiveData<List<SurahModel>>()

    val liveData: LiveData<List<SurahModel>> = mutableLiveData


    fun getRehmanList() {
        viewModelScope.launch {
            val list = surahRepo.getSurahRehman()
            mutableLiveData.postValue(list)

        }
    }

    fun getYaseenList() {
        viewModelScope.launch {
            val list = surahRepo.getSurahYaseen()
            mutableLiveData.postValue(list)
        }
    }

    fun getAllahNames() {
        viewModelScope.launch {

        }
    }
}