package com.example.pocketengineer.ui.main.viewmodel

import android.hardware.Sensor
import android.hardware.SensorEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pocketengineer.persistence.RoomLighting
import com.google.firebase.database.*


class LightSensorViewModel : ViewModel() {

    private var roomLightingList : ArrayList<RoomLighting> = arrayListOf()
    private val _brightness: MutableLiveData<Double> = MutableLiveData<Double>(0.0)
    val brightness: LiveData<Double> = _brightness


    fun onSensorChanged(sensorEvent: SensorEvent?) {
        if(sensorEvent?.sensor?.type == Sensor.TYPE_LIGHT){
            _brightness.value?.let {_brightness.postValue(sensorEvent.values[0].toDouble()) }
        }
    }



    fun addUser(newRoom: RoomLighting, Database: DatabaseReference) {
        Database.push().setValue(newRoom)
    }

    fun getData(children: Iterable<DataSnapshot>, Database: DatabaseReference): ArrayList<RoomLighting> {
        for(roomsSnapshot in children){
            val rooms = roomsSnapshot.getValue(RoomLighting::class.java)
            //!! makes sure that rooms object is not null. If it is NullException is thrown
            roomLightingList.add(rooms!!)
        }
        return roomLightingList
    }
}