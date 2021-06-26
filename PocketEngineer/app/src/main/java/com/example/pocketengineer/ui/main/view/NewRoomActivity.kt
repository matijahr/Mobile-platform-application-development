package com.example.pocketengineer.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pocketengineer.databinding.NewRoomLayoutBinding
import com.example.pocketengineer.databinding.RoomLightingItemBinding
import com.example.pocketengineer.persistence.RoomLighting
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NewRoomActivity : AppCompatActivity() {

    lateinit var binding: NewRoomLayoutBinding
    private val KEY_MESSAGE: String = "message"
    private lateinit var Database : DatabaseReference
    private val ERROR_MESSAGE: String = "You have to input a room name"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewRoomLayoutBinding.inflate(layoutInflater)
        Database = FirebaseDatabase.getInstance().getReference("roomLighting")

        val sensorValue = intent.getSerializableExtra(KEY_MESSAGE) as? String
        if (sensorValue != null){
            binding.tvRoomLighting.text = sensorValue
            binding.btnCommit.setOnClickListener { addNewRoomToDatabase(sensorValue) }
        }



        setContentView(binding.root)

    }

    private fun addNewRoomToDatabase(sensorValue: String) {
        try {
            val newRoom = RoomLighting(
                    binding.etRoomName.text.toString(),
                    sensorValue.toInt()
            )

            //check is user has inputted a room name
            if (newRoom.roomName.isBlank()){
                throw Exception(ERROR_MESSAGE)
            }

            val putRoom = Intent(this, LightSensorActivity::class.java)
            putRoom.putExtra(KEY_MESSAGE, newRoom)
            startActivity(putRoom)


        }catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

}
