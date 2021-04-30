package com.example.lv3

import android.app.Application
import android.content.Context

// Kreiramo vlasitu klasu koja nam drži aplikacijski kontekst
// kojem ćemo moći pristupiti u različitim dijelovima aplikacija
class BirdCounter : Application() {
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}