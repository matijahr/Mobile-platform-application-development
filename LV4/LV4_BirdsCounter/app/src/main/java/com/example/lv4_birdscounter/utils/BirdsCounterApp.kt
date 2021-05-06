package com.example.lv4_birdscounter.utils

import android.app.Application
import android.content.Context

// Kreiramo vlasitu klasu koja nam drži aplikacijski kontekst
// kojem ćemo moći pristupiti u različitim dijelovima aplikacija
class BirdsCounterApp : Application(){

    companion object {
        lateinit var ApplicationContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        ApplicationContext = applicationContext
    }


}