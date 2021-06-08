package com.example.pocketengineer

import android.app.Application
import android.content.Context

class PocketEngineerApp : Application() {
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}