package com.example.pocketengineer.utilities

fun getValueFromBands(value: String): Int{
    return when(value){
        "Black" -> 0
        "Brown" -> 1
        "Red" -> 2
        "Orange" -> 3
        "Yellow" -> 4
        "Green" -> 5
        "Blue" -> 6
        "Violet" -> 7
        "Grey" -> 8
        "White" -> 9
        else -> 404
    }
}

fun getValueForMultiplier(value: String): Double{
    return when(value){
        "Black" -> 1.0
        "Brown" -> 10.0
        "Red" -> 100.0
        "Orange" -> 1000.0
        "Yellow" -> 10000.0
        "Green" -> 100000.0
        "Blue" -> 1000000.0
        "Violet" -> 10000000.0
        "Grey" -> 100000000.0
        "White" -> 1000000000.0
        "Gold" -> 0.1
        "Silver" -> 0.01
        else -> 404.0
    }
}

fun getValueForTolerance(value: String): Double{
    return when(value){
        "Brown" -> 1.0
        "Red" -> 2.0
        "Green" -> 0.5
        "Blue" -> 0.25
        "Violet" -> 0.1
        "Grey" -> 0.05
        "Gold" -> 5.0
        "Silver" -> 10.0
        else -> 404.0
    }
}