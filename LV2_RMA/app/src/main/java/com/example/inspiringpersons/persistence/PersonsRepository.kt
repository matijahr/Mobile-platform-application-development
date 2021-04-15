package com.example.inspiringpersons.persistence

import com.example.inspiringpersons.models.InspiringPerson

object PersonsRepository {
    private val persons = mutableListOf<InspiringPerson>(
        InspiringPerson(
            "Linus Torvalds",
            "Creator of Linux",
            "28.12.1969.",
            "Talk is cheap. Show me the code.",
            "https://upload.wikimedia.org/wikipedia/commons/0/01/LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg"),
        InspiringPerson(
            "Dennis Ritchie",
            "Creator of C programming language",
            "9.9.1941.",
            "The only way to learn a new programming language is by writing programs in it.",
            "https://media.boingboing.net/wp-content/uploads/2011/10/dennis_ritchie.jpg"
        )
    )

    fun add(person: InspiringPerson) = persons.add(person)
    fun getPersons(): List<InspiringPerson> = persons
}