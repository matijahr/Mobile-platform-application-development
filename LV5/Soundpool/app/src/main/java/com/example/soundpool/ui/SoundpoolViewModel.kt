package com.example.soundpool.ui

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import androidx.lifecycle.ViewModel
import com.example.soundpool.R
import com.example.soundpool.SoundpoolApp
import com.example.soundpool.sounds.AudioPlayer
import com.example.soundpool.sounds.SoundPoolPlayer

class SoundpoolViewModel(private val audioPlayer: AudioPlayer) : ViewModel(){

    fun playSound(selectedSound: Int) = audioPlayer.playSound(selectedSound)

}