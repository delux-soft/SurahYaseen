package com.example.surahyaseen.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.surahyaseen.repo.MainRepo
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class MainVM<T> : ViewModel() {
    private val mainRepo by lazy {
        MainRepo()
    }

    private val mutableLiveData = MutableLiveData<List<T>>()
    val liveData: LiveData<List<T>> = mutableLiveData


    fun getRehmanList() {
        viewModelScope.launch {
            val list = mainRepo.getSurahRehman() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getYaseenList() {
        viewModelScope.launch {
            val list = mainRepo.getSurahYaseen() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getAllahNames() {
        viewModelScope.launch {
            val list = mainRepo.getAllahAttributes() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getMuhammadName() {
        viewModelScope.launch {
            val list = mainRepo.getMuhammadAttributes() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getQalma() {
        viewModelScope.launch {
            val list = mainRepo.getQalma() as List<T>
            mutableLiveData.postValue(list)
        }
    }


}