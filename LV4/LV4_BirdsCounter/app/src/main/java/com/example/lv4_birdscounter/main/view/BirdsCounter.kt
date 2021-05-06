package com.example.lv4_birdscounter.main.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lv4_birdscounter.main.viewmodel.BirdsCounterViewModel
import com.example.lv4_birdscounter.PrefsManager
import com.example.lv4_birdscounter.R
import com.example.lv4_birdscounter.UserDataProvider
import com.example.lv4_birdscounter.databinding.ActivityMainBinding


class BirdsCounter : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: BirdsCounterViewModel

    private val userDataProvider: UserDataProvider by lazy { PrefsManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(BirdsCounterViewModel::class.java)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.lifecycleOwner = this@BirdsCounter
            this.viewmodel=viewModel
        }

        viewModel.birdsSeen.observe(this, Observer {
            //display new data
            binding.tvCounter.text = it.toString()

        })

        viewModel.birdsColor.observe(this, Observer {
            //display new data
            binding.tvCounter.setBackgroundColor(Color.parseColor(it))

            //Make number more visible by changing the colour of the text
            when(it){
                viewModel.GREEN -> binding.tvCounter.setTextColor(Color.BLACK)
                viewModel.WHITE -> binding.tvCounter.setTextColor(Color.BLACK)
                else -> binding.tvCounter.setTextColor(Color.WHITE)
            }
        })

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.tvCounter.text = userDataProvider.birdCounter.toString()
        binding.tvCounter.setBackgroundColor(Color.parseColor(userDataProvider.tvColor))

        //Make number more visible by changing the colour of the text
        when(userDataProvider.tvColor){
            viewModel.GREEN -> binding.tvCounter.setTextColor(Color.BLACK)
            viewModel.WHITE -> binding.tvCounter.setTextColor(Color.BLACK)
            else -> binding.tvCounter.setTextColor(Color.WHITE)
        }
    }


}