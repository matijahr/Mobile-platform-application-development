package com.example.pocketengineer.utilities

fun getValueFromIlluminances(value: Double): String{
    return when(value){
        0.0 -> "Pitch black"
        in 1.0..10.0 -> "Very Dark"
        in 11.0..50.0 -> "Dark"
        in 51.0..5000.0 -> "Well lighted"
        in 5001.0..30000.0 -> "Incredibly bright"
        else -> "Something went wrong"
    }
}
