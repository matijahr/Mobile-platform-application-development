package com.example.pocketengineer.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketengineer.databinding.ItemTitleBinding
import com.example.pocketengineer.databinding.RoomLightingItemBinding
import com.example.pocketengineer.persistence.RoomLighting

class RoomLightingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(room : RoomLighting){
        val itemBinding = RoomLightingItemBinding.bind(itemView)

        itemBinding.tvRoomName.text = room.roomName + ":"
        itemBinding.tvRoomLighting.text = room.lighting.toString()

    }
}
