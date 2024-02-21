package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.repo.MainRepo
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.repo.SupplicationRepo
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.repo.TasbeehRepo
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class MainVM<T> : ViewModel() {


    private val mutableLiveData = MutableLiveData<List<T>>()
    val liveData: LiveData<List<T>> = mutableLiveData

    fun getRehmanList() {
        viewModelScope.launch {
            val list = MainRepo.getSurahRehman() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getYaseenList() {
        viewModelScope.launch {
            val list = MainRepo.getSurahYaseen() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getAllahNames() {
        viewModelScope.launch {
            val list = MainRepo.getAllahAttributes() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getMuhammadName() {
        viewModelScope.launch {
            val list = MainRepo.getMuhammadAttributes() as List<T>
            mutableLiveData.postValue(list)
        }
    }


    fun getQalma() {
        viewModelScope.launch {
            val list = MainRepo.getQalma() as List<T>
            mutableLiveData.postValue(list)
        }
    }

    fun getQul() {
        viewModelScope.launch {
            val list = MainRepo.getQul() as List<T>
            mutableLiveData.postValue(list)
        }
    }

    fun getSupplication() {
        viewModelScope.launch {
            val list = SupplicationRepo.getSupplications() as List<T>
            mutableLiveData.postValue(list)
        }
    }

    fun getTasbeeh() {
        viewModelScope.launch {
            val list = TasbeehRepo.getTasbeeh() as List<T>
            mutableLiveData.postValue(list)
        }
    }


}