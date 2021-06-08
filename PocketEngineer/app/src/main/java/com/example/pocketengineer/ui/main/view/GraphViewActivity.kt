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

    lateinit var series: LineGraphSeries<DataPoint>
    var x: Double = 0.0
    var y: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = GraphViewActivityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(GraphViewViewModel::class.java)

        binding.btnDraw.setOnClickListener { drawFunction() }
        /*
        series = LineGraphSeries<DataPoint>()
        x = 0.0
        for (i in 0..1000) {
            x += 0.1
            y = sin(x)

            series.appendData(DataPoint(x,y),true, 1000)
        }

        binding.graph.addSeries(series)*/

        setContentView(binding.root)
    }

    private fun drawFunction() {

        if (!binding.swEnableMultiple.isChecked){
            binding.graph.removeAllSeries()
        }

        val amplitude = binding.tvAmplitude.text.toString().toDouble()
        var value = binding.tvValue.text.toString().toDouble()
        series = LineGraphSeries<DataPoint>()

        /*
        x = 0.0
        for (i in 0..1000) {
            x += 0.1

            var point = DataPoint(0.0,0.0)

            var id = binding.rgTrigFunc.checkedRadioButtonId
            when(id){
                R.id.rb_sine -> viewModel.drawSine(x,amplitude,value)
            }

            //var point = viewModel.drawSine(x, amplitude, value)
            series.appendData(point,true, 1000)
        }*/




        binding.rgTrigFunc.setOnCheckedChangeListener { group, selectedID ->
            if (selectedID == R.id.rb_sine){
                x = 0.0
                for (i in 0..1000) {
                    x += 0.1

                    var point = viewModel.drawSine(x, amplitude, value)
                    series.appendData(point,true, 1000)
                }
            }
        }

        binding.graph.addSeries(series)
    }




}
