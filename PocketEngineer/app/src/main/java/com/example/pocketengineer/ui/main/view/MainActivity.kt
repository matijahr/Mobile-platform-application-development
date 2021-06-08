package com.example.pocketengineer.ui.main.view

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pocketengineer.adapters.ActivitiesAdapter
import com.example.pocketengineer.databinding.PocketEngineerMainBinding
import com.example.pocketengineer.persistence.Titles

class MainActivity : AppCompatActivity() {

    private lateinit var binding: PocketEngineerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PocketEngineerMainBinding.inflate(layoutInflater)

        binding.recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.recyclerView.adapter = ActivitiesAdapter(Titles.getTitle())

        setContentView(binding.root)
    }

}