package com.example.pocketengineer.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketengineer.databinding.ItemTitleBinding

class ActivitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(titles : String){
        val itemBinding = ItemTitleBinding.bind(itemView)

        itemBinding.tvActivityTitle.text = titles
    }

}