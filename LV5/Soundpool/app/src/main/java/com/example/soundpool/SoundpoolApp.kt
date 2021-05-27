package com.example.soundpool

import android.app.Application
import android.content.Context
import com.example.soundpool.di.appModule
import com.example.soundpool.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SoundpoolApp : Application() {

    /*companion object {
        lateinit var ApplicationContext: Context
    }*/

    override fun onCreate() {
        super.onCreate()
        //ApplicationContext = applicationContext
        startKoin {
            androidContext(this@SoundpoolApp)
            modules(appModule, viewModelModule)
        }
    }
}