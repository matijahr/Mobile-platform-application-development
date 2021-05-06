package com.example.lv4_test.data.api

import com.example.lv4_test.data.model.User
import io.reactivex.Single

interface ApiService{
    fun getUsers(): Single<List<User>>
}