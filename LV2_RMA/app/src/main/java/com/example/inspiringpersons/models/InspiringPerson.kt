package com.example.inspiringpersons.models

import android.media.Image
import java.io.Serializable
data class InspiringPerson(
        val name: String,
        val description: String,
        val DoB:String,
        val quote: String,
        val image: String
) : Serializable