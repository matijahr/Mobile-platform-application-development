package com.example.pocketengineer.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.DataPointInterface
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.Series
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.tan


class GraphViewViewModel : ViewModel() {
    private lateinit var series: LineGraphSeries<DataPoint>
    private var x: Double = 0.0

    fun drawSine(amplitude: Double, frequency: Double): LineGraphSeries<DataPoint> {
        x = 0.0
        series = LineGraphSeries<DataPoint>()

        for (i in 0..1000) {
            x += 0.1

            series.appendData(DataPoint(x,amplitude * sin(frequency*x)),true, 1000)
        }
        return series
    }

    fun drawCosine(amplitude: Double, frequency: Double): LineGraphSeries<DataPoint> {
        x = 0.0
        series = LineGraphSeries<DataPoint>()

        for (i in 0..1000) {
            x += 0.1

            series.appendData(DataPoint(x,amplitude * cos(frequency*x)),true, 1000)
        }
        return series
    }

    fun drawTang(amplitude: Double, frequency: Double): LineGraphSeries<DataPoint> {
        x = 0.0
        series = LineGraphSeries<DataPoint>()

        for (i in 0..1000) {
            x += 0.1

            series.appendData(DataPoint(x,amplitude * tan(frequency*x)),true, 1000)
        }
        return series
    }
}