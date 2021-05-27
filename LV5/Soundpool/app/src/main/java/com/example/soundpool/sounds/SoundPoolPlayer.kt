package com.example.soundpool.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.provider.MediaStore
import com.example.soundpool.R
import com.example.soundpool.SoundpoolApp

class SoundPoolPlayer(context: Context) : AudioPlayer {
    private val priority: Int = 1
    private val maxStreams: Int = 3
    private val srcQuality: Int = 1

    private val leftVolume = 1f
    private val righVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private lateinit var soundPool: SoundPool
    var soundMap: HashMap<Int, Int> = HashMap()



    init {
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build()
            soundPool = SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(maxStreams)
                    .build()
        }else{
            soundPool = SoundPool(maxStreams, AudioManager.USE_DEFAULT_STREAM_TYPE, srcQuality)
        }
        /*
        bahra1 -> Moja moć je jako veoma velika
        bahra2 -> Ja živim u normalnom stoljeću
        bahra6 -> Muti kaša, mutavela
        bahra4 -> sprechen Sie Bahra
        bahra5 -> Dokazalo se da je svjetski čovjek
        bahra6 -> Najljepša karijera
        */

        soundMap[R.raw.bahra1] = soundPool.load(context, R.raw.bahra1, priority)
        soundMap[R.raw.bahra2] = soundPool.load(context, R.raw.bahra2, priority)
        soundMap[R.raw.bahra3] = soundPool.load(context, R.raw.bahra3, priority)
        soundMap[R.raw.bahra4] = soundPool.load(context, R.raw.bahra4, priority)
        soundMap[R.raw.bahra5] = soundPool.load(context, R.raw.bahra5, priority)
        soundMap[R.raw.bahra6] = soundPool.load(context, R.raw.bahra6, priority)

    }

    override fun playSound(selectedSound: Int) {
        soundMap[selectedSound]?.let { soundPool.play(it, leftVolume, righVolume, priority, shouldLoop ,playbackRate) }
    }
}