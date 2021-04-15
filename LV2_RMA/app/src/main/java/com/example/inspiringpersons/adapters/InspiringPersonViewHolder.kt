package com.example.inspiringpersons.adapters
import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersons.R
import com.example.inspiringpersons.databinding.ItemInspiringPersonBinding
import com.example.inspiringpersons.models.InspiringPerson
import com.squareup.picasso.Picasso



class InspiringPersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(inspPerson:InspiringPerson){
        val itemBinding=ItemInspiringPersonBinding.bind(itemView)

        itemBinding.tvNoteItemName.text = inspPerson.name
        itemBinding.tvNoteItemDescription.text = inspPerson.description
        itemBinding.tvNoteItemDoB.text="Date of Birth: " + inspPerson.DoB

        Picasso.get()
                .load(inspPerson.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(android.R.drawable.stat_notify_error)
                .into(itemBinding.ivInspiringPerson)

        itemBinding.ivInspiringPerson.setOnClickListener{MakeToast(itemView,inspPerson)}
    }

    private fun MakeToast(itemView: View,inspPerson:InspiringPerson) {
        Toast.makeText(itemView.context, inspPerson.quote, Toast.LENGTH_SHORT).show()
    }

}