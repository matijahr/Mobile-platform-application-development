package com.example.pocketengineer.ui.main.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pocketengineer.R
import com.example.pocketengineer.databinding.GraphViewActivityBinding
import com.example.pocketengineer.ui.main.viewmodel.GraphViewViewModel
import com.example.pocketengineer.ui.main.viewmodel.LightSensorViewModel
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.math.sin


class GraphViewActivity : AppCompatActivity() {

    private lateinit var binding: GraphViewActivityBinding
    private lateinit var viewModel: GraphViewViewModel
    private val ERROR_MESSAGE: String = "You have to fill all the required fields"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = GraphViewActivityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(GraphViewViewModel::class.java)


        binding.btnDraw.setOnClickListener { drawFunction() }

        setContentView(binding.root)
    }

    private fun drawFunction() {

        if (!binding.swEnableMultiple.isChecked){
            binding.graph.removeAllSeries()
        }

        try {
            //is TextView is empty an Exception object is thrown with ERROR_MESSAGE
            if(binding.tvAmplitude.text.isNullOrEmpty() || binding.tvValue.text.isNullOrEmpty()){
                throw Exception(ERROR_MESSAGE)
            }
            val amplitude = binding.tvAmplitude.text.toString().toDouble()
            var value = binding.tvValue.text.toString().toDouble()

            //check which RadioButton is checked
            if (binding.rbSine.isChecked){
                binding.graph.addSeries(viewModel.drawSine(amplitude,value))
            }else if(binding.rbCosine.isChecked){
                binding.graph.addSeries(viewModel.drawCosine(amplitude,value))
            }else if(binding.rbTang.isChecked){
                binding.graph.addSeries(viewModel.drawTang(amplitude,value))
            }

        }catch (e: Exception){
            Toast.makeText(this, e.message,Toast.LENGTH_LONG).show()
        }
    }



}
