package com.example.lv4_birdscounter.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lv4_birdscounter.PrefsManager
import com.example.lv4_birdscounter.UserDataProvider


class BirdsCounterViewModel() : ViewModel() {

    private val userDataProvider: UserDataProvider by lazy { PrefsManager }
    val RED = "#D82929"
    val BLUE = "#2121E1"
    val WHITE = "#FFFFFFFF"
    val GREEN = "#2DF62D"
    val LIGHT_GRAY = "#4A6572"

    private val _birdsSeen: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val birdsSeen: LiveData<Int> = _birdsSeen

    private val _birdsColor: MutableLiveData<String> = MutableLiveData<String>("#4A6572")
    val birdsColor: LiveData<String> = _birdsColor

    fun onButtonPressed(color: String){
        userDataProvider.birdCounter += 1
        userDataProvider.tvColor = color

        _birdsSeen.value?.let { _birdsSeen.postValue(userDataProvider.birdCounter) }
        _birdsColor.value?.let { _birdsColor.postValue(userDataProvider.tvColor) }

    }

    fun onResetButtonPressed(){
        userDataProvider.birdCounter = 0
        userDataProvider.tvColor = LIGHT_GRAY

        _birdsSeen.value?.let { _birdsSeen.postValue(0) }
        _birdsColor.value?.let { _birdsColor.postValue(LIGHT_GRAY) }
    }




}