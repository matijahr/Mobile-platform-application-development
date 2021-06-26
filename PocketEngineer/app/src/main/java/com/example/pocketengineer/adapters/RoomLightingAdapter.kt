package com.example.pocketengineer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketengineer.R
import com.example.pocketengineer.persistence.RoomLighting
import java.util.ArrayList

class RoomLightingAdapter(val roomList: ArrayList<RoomLighting>) : RecyclerView.Adapter<RoomLightingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomLightingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.room_lighting_item, parent, false)
        return RoomLightingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomLightingViewHolder, position: Int) {
        val room = roomList[position]
        holder.bind(room)
    }

    override fun getItemCount(): Int {
        return roomList.size
    }



}
