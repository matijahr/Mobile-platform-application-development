package com.example.inspiringpersons.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersons.R
import com.example.inspiringpersons.models.InspiringPerson

class InspiringPersonAdapter(val inspiringPerson: List<InspiringPerson>) : RecyclerView.Adapter<InspiringPersonViewHolder>() {

    private val persons: MutableList<InspiringPerson> = mutableListOf()

    init{
        refreshData(inspiringPerson)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspiringPersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inspiring_person, parent, false)

        return InspiringPersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: InspiringPersonViewHolder, position: Int) {
        val person: InspiringPerson = inspiringPerson[position]

        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return inspiringPerson.size
    }

    fun refreshData(newPersons: List<InspiringPerson>){
        this.persons.clear()
        this.persons.addAll(newPersons)
        this.notifyDataSetChanged()
    }
}
