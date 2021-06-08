package com.example.pocketengineer.persistence

import java.io.Serializable

data class RoomLighting(
        var roomName: String = "",
        var lighting: Double = 0.0
) : Serializable
