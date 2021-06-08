package com.example.pocketengineer.ui.main.view

import android.content.Intent
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewRoomLayoutBinding.inflate(layoutInflater)
        Database = FirebaseDatabase.getInstance().getReference("roomLighting")

        val sensorValue = intent.getSerializableExtra(KEY_MESSAGE) as? String
        if (sensorValue != null){
            binding.bCommit.setOnClickListener { addNewRoomToDatabase(sensorValue) }
        }



        setContentView(binding.root)

    }

    private fun addNewRoomToDatabase(sensorValue: String) {
        val newRoom = RoomLighting(
            binding.etRoomName.text.toString(),
            10.0
            //sensorValue.toDouble()
        )

        val putRoom = Intent(this, LightSensorActivity::class.java)
        putRoom.putExtra(KEY_MESSAGE, newRoom)
        startActivity(putRoom)
    }

}
