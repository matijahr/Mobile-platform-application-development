package com.example.pocketengineer.persistence

import java.io.Serializable

data class RoomLighting(
        var roomName: String = "",
        var lighting: Int = 0
) : Serializable
