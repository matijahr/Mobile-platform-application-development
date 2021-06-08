package com.example.pocketengineer.persistence

object Titles {
    private val titles = mutableListOf<String>(
        "4 Band Resistor Color Code Calculator",
        "Light sensor",
        "Draw a function"
    )

    fun add(newTitle: String) = titles.add(newTitle)
    fun getTitle(): List<String> = titles

}