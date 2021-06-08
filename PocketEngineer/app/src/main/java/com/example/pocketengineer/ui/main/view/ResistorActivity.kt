package com.example.pocketengineer.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pocketengineer.ResistorPrefsManager
import com.example.pocketengineer.UserDataProvider
import com.example.pocketengineer.databinding.ResistoryActivityBinding
import com.example.pocketengineer.persistence.ResistorOptions
import com.example.pocketengineer.ui.main.viewmodel.ResistorViewModel


class ResistorActivity : AppCompatActivity() {

    private lateinit var binding: ResistoryActivityBinding
    lateinit var viewModel: ResistorViewModel
    private val userDataProvider: UserDataProvider by lazy { ResistorPrefsManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ResistoryActivityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(ResistorViewModel::class.java)

        // attaching ArrayAdapters to all spinners
        setUpSpinnerAdapter()

        // attaching listeners to spinners
        setUpSpinnerListener()

        // button listener
        binding.btnCalculate.setOnClickListener { printResult() }

        setContentView(binding.root)
    }

    private fun setUpSpinnerListener() {
        binding.spFirstBand.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //sending data to viewModel to be processed
                viewModel.setFirstBand(ResistorOptions.bandColors[p2])
                userDataProvider.firstBand = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.txtResult.text = "Please select 1st band color"
            }

        }

        binding.spSecondBand.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.setSecondBand(ResistorOptions.bandColors[p2])
                userDataProvider.secondBand = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.txtResult.text = "Please select 2nd band color"
            }

        }

        binding.spMultiplier.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.setMultiplier(ResistorOptions.multiplierColors[p2])
                userDataProvider.multiplier = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.txtResult.text = "Please select a multiplier"
            }

        }

        binding.spTolerance.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.setTolerance(ResistorOptions.toleranceColors[p2])
                userDataProvider.tolerance = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                binding.txtResult.text = "Please select a resistor tolerance"
            }

        }
    }

    private fun setUpSpinnerAdapter() {
        binding.spFirstBand.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResistorOptions.bandColors)
        binding.spSecondBand.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResistorOptions.bandColors)
        binding.spMultiplier.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResistorOptions.multiplierColors)
        binding.spTolerance.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ResistorOptions.toleranceColors)
    }

    private fun printResult() {
        //getting result that is being printed
        val res = viewModel.print()
        //saving result
        userDataProvider.resault = res

        binding.txtResult.text = res

    }

    override fun onResume() {
        super.onResume()

        binding.spFirstBand.setSelection(userDataProvider.firstBand)
        binding.spSecondBand.setSelection(userDataProvider.secondBand)
        binding.spMultiplier.setSelection(userDataProvider.multiplier)
        binding.spTolerance.setSelection(userDataProvider.tolerance)
        binding.txtResult.text = userDataProvider.resault
    }

}