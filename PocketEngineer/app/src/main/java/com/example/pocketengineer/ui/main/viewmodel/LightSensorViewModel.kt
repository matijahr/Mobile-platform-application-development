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
    private val _brightness: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val brightness: LiveData<Int> = _brightness


    fun onSensorChanged(sensorEvent: SensorEvent?) {
        //making sure that sensorEvent is from light sensor
        if(sensorEvent?.sensor?.type == Sensor.TYPE_LIGHT){
            _brightness.value?.let {_brightness.postValue(sensorEvent.values[0].toInt()) }
        }
    }



    fun addUser(newRoom: RoomLighting, Database: DatabaseReference) {
        Database.push().setValue(newRoom)
    }

    fun getData(children: Iterable<DataSnapshot>): ArrayList<RoomLighting> {
        //erase old data so it doesn't duplicate
        roomLightingList.clear()

        for(roomsSnapshot in children){
            val rooms = roomsSnapshot.getValue(RoomLighting::class.java)
            //!! makes sure that rooms object is not null. If it is NullException is thrown
            roomLightingList.add(rooms!!)
        }
        return roomLightingList
    }
}