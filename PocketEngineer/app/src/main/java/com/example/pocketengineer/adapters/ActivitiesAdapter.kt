package com.example.pocketengineer.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketengineer.ui.main.view.LightSensorActivity
import com.example.pocketengineer.R
import com.example.pocketengineer.ui.main.view.GraphViewActivity
import com.example.pocketengineer.ui.main.view.ResistorActivity

class ActivitiesAdapter(val titles: List<String>) : RecyclerView.Adapter<ActivitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_title, parent, false)
        return ActivitiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val title = titles[position]
        holder.bind(title)

        holder.itemView.setOnClickListener{goToActivity(holder.itemView.context, position)}
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}

private fun goToActivity(context: Context,position: Int) {
    if (position == 0){
        context.startActivity(
            Intent(context, ResistorActivity::class.java)
        )
    }
    if (position == 1){
        context.startActivity(
            Intent(context, LightSensorActivity::class.java)
        )
    }
    if (position == 2){
        context.startActivity(
                Intent(context, GraphViewActivity::class.java)
        )
    }
}