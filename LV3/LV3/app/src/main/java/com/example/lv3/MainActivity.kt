package com.example.lv3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lv3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    private val userDataProvider: UserDataProvider by lazy { PrefsManager }

    val RED = "#D82929"
    val BLUE = "#2121E1"
    val WHITE = "#FFFFFFFF"
    val GREEN = "#2DF62D"
    val LIGHT_GRAY = "#4A6572"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding= ActivityMainBinding.inflate(layoutInflater)

        mainBinding.btnRed.setOnClickListener{onButtonPressed(RED)}
        mainBinding.btnBlue.setOnClickListener{onButtonPressed(BLUE)}
        mainBinding.btnWhite.setOnClickListener{onButtonPressed(WHITE)}
        mainBinding.btnGreen.setOnClickListener{onButtonPressed(GREEN)}
        mainBinding.btnReset.setOnClickListener{onResetButtonPressed()}

        setContentView(mainBinding.root)
    }

    private fun onResetButtonPressed() {
        userDataProvider.birdCounter=0

        mainBinding.tvCounter.text = ""
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor(LIGHT_GRAY))
        userDataProvider.tvColor=LIGHT_GRAY
    }

    private fun onButtonPressed(color: String) {
        when(color){
            GREEN -> mainBinding.tvCounter.setTextColor(Color.BLACK)
            WHITE -> mainBinding.tvCounter.setTextColor(Color.BLACK)
            else -> mainBinding.tvCounter.setTextColor(Color.WHITE)
        }
        userDataProvider.birdCounter++

        mainBinding.tvCounter.text = userDataProvider.birdCounter.toString()
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor(color))


        userDataProvider.tvColor = color

    }

    override fun onResume() {
        super.onResume()

        if (userDataProvider.birdCounter==0){
            mainBinding.tvCounter.text = ""
        }else{
            mainBinding.tvCounter.text = userDataProvider.birdCounter.toString()
        }

        mainBinding.tvCounter.setBackgroundColor(Color.parseColor(userDataProvider.tvColor))

        when(userDataProvider.tvColor){
            GREEN -> mainBinding.tvCounter.setTextColor(Color.BLACK)
            WHITE -> mainBinding.tvCounter.setTextColor(Color.BLACK)
            else -> mainBinding.tvCounter.setTextColor(Color.WHITE)
        }

    }



}