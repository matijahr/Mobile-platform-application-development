package com.example.pocketengineer.utilities

fun getValueFromIlluminance(value: Int): String{
    return when(value){
        0 -> "Pitch black"
        in 1..10 -> "Very dark"
        in 11..50 -> "Dark"
        in 51..5000 -> "Well lighted"
        in 5001..30000 -> "Incredibly bright"
        else -> "Something went wrong"
    }
}


