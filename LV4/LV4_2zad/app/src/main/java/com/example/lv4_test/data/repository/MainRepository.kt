package com.example.lv4_test.data.repository

import com.example.lv4_test.data.api.ApiHelper
import com.example.lv4_test.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {
    fun getUsers(): Single<List<User>>{
        return apiHelper.getUsers()
    }
}