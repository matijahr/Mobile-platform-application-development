package com.example.soundpool.di

import com.example.soundpool.sounds.AudioPlayer
import com.example.soundpool.sounds.SoundPoolPlayer
import com.example.soundpool.ui.SoundpoolViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AudioPlayer> { SoundPoolPlayer(androidContext()) }
}

val viewModelModule = module {
    viewModel{ SoundpoolViewModel(get()) }
}