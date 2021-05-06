package com.example.lv4_test.ui.main.adapter

import android.content.ClipData
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lv4_test.R
import com.example.lv4_test.data.model.User
import com.example.lv4_test.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso


class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(user: User){
            var itemBinding = ItemLayoutBinding.bind(itemView)

            itemBinding.textViewUserName.text = user.name
            itemBinding.textViewUserEmail.text = user.email

            Picasso.get()
                .load(user.avatar)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(android.R.drawable.stat_notify_error)
                .into(itemBinding.imageViewAvatar)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        return holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addData (list: List<User>){
        users.addAll(list)
    }
}