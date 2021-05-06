package com.example.lv4_test.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lv4_test.data.api.ApiHelper
import com.example.lv4_test.data.repository.MainRepository
import com.example.lv4_test.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val  apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return  MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalAccessException("Unknown class name")
    }
}