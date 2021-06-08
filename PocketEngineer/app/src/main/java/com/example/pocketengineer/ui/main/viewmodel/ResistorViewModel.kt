package com.example.pocketengineer.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pocketengineer.utilities.getValueForMultiplier
import com.example.pocketengineer.utilities.getValueForTolerance
import com.example.pocketengineer.utilities.getValueFromBands



class ResistorViewModel : ViewModel() {

    var firstColor  : Int = 0
    var secondColor  : Int = 0
    var multiplier  : Double = 0.0
    var tolerance  : Double = 0.0

    fun setFirstBand(color: String){
        // converting string color to corresponding int value
        firstColor = getValueFromBands(color)
    }

    fun setSecondBand(color: String){
        // converting string color to corresponding int value
        secondColor = getValueFromBands(color)
    }

    fun setMultiplier(color: String){
        // converting string color to corresponding double value
        multiplier = getValueForMultiplier(color)
    }

    fun setTolerance(color: String){
        // converting string color to corresponding double value
        tolerance = getValueForTolerance(color)
    }

    fun print():String{
        // [(firstColor)(secondColor)]*multiplier
        var temp = firstColor.toString() + secondColor.toString()
        var res = temp.toDouble() * multiplier


        return res.toString() + "Ohms " + tolerance + "%"

    }


}