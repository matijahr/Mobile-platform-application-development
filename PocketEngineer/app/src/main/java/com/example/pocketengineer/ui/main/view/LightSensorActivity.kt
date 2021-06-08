package com.example.pocketengineer.ui.main.view

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pocketengineer.PocketEngineerApp
import com.example.pocketengineer.adapters.RoomLightingAdapter
import com.example.pocketengineer.databinding.LightSensorActivityBinding
import com.example.pocketengineer.persistence.RoomLighting
import com.example.pocketengineer.ui.main.viewmodel.LightSensorViewModel
import com.example.pocketengineer.utilities.getValueFromIlluminances
import com.google.firebase.database.*

class LightSensorActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var binding: LightSensorActivityBinding
    lateinit var viewModel: LightSensorViewModel
    private val sensorManager = PocketEngineerApp.context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    private val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    private lateinit var Database : DatabaseReference
    private val KEY_MESSAGE: String = "message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LightSensorActivityBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(LightSensorViewModel::class.java)

        // referente to firebase
        Database = FirebaseDatabase.getInstance().getReference("roomLighting")

        // getting new room from NewRoomActivity
        val newRoom = intent.getSerializableExtra(KEY_MESSAGE) as? RoomLighting
        if(newRoom != null){
            //add to database
            viewModel.addUser(newRoom, Database)

        }

        // set up recycler view
        binding.rvViewFavorites.layoutManager = LinearLayoutManager(this)
        getDatabaseData()


        // getting and displaying data from sensor
        viewModel.brightness.observe(this, Observer{
            binding.txtSensorValue.text = it.toString()
            binding.txtLightning.text = getValueFromIlluminances(it)
        })

        binding.fabAddRoom.setOnClickListener{addRoomToDatabase()}
        setContentView(binding.root)
    }



    private fun getDatabaseData(){

        Database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){

                    binding.rvViewFavorites.adapter = RoomLightingAdapter(
                        viewModel.getData(snapshot.children, Database)
                    )

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }


    private fun addRoomToDatabase() {
        val sensorValue = binding.txtSensorValue.toString()
        val intent = Intent(this,NewRoomActivity::class.java)
        intent.putExtra(KEY_MESSAGE, sensorValue)
        startActivity(intent)
    }


    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        viewModel.onSensorChanged(sensorEvent)
    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}


    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }


    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL )
    }

}


