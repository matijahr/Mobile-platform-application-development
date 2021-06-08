package com.example.pocketengineer.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.jjoe64.graphview.series.DataPoint
import kotlin.math.sin


class GraphViewViewModel : ViewModel() {


    fun drawSine(x: Double, amplitude: Double, value: Double): DataPoint{
        return DataPoint(x,(amplitude* sin(value*x)))
    }

}