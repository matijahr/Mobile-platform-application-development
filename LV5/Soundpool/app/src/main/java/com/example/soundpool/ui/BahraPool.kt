package com.example.soundpool.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soundpool.R
import com.example.soundpool.databinding.BahrapoolMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class BahraPool : AppCompatActivity() {

    private lateinit var binding: BahrapoolMainBinding
    private val viewModel by viewModel<SoundpoolViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = BahrapoolMainBinding.inflate(layoutInflater)

        binding.btnBahra1.setOnClickListener { viewModel.playSound(R.raw.bahra1) }
        binding.btnBahra2.setOnClickListener { viewModel.playSound(R.raw.bahra2) }
        binding.btnBahra3.setOnClickListener { viewModel.playSound(R.raw.bahra3) }
        binding.btnBahra4.setOnClickListener { viewModel.playSound(R.raw.bahra4) }
        binding.btnBahra5.setOnClickListener { viewModel.playSound(R.raw.bahra5) }
        binding.btnBahra6.setOnClickListener { viewModel.playSound(R.raw.bahra6) }

        setContentView(binding.root)
    }

}
