package com.example.pocketengineer.persistence

object Titles {
    private val titles = listOf<String>(
        "4 Band Resistor Color Code Calculator",
        "Light sensor",
        "Draw a function"
    )

    fun getTitle(): List<String> = titles

}