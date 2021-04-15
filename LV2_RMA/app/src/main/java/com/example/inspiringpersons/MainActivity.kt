package com.example.inspiringpersons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersons.activities.NewInspiringPersonActivity
import com.example.inspiringpersons.adapters.InspiringPersonAdapter
import com.example.inspiringpersons.databinding.ActivityMainBinding
import com.example.inspiringpersons.models.InspiringPerson
import com.example.inspiringpersons.persistence.PersonsRepository
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val adapter = InspiringPersonAdapter(PersonsRepository.getPersons())
    private val KEY_MESSAGE: String = "message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newInputPerson = intent.getSerializableExtra(KEY_MESSAGE) as? InspiringPerson
        if(newInputPerson != null){
            PersonsRepository.add(newInputPerson)
        }

        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddNote.setOnClickListener{createNewInspiringPerson()}

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        )
        mainBinding.recyclerView.adapter = InspiringPersonAdapter(PersonsRepository.getPersons())

        setContentView(mainBinding.root)
    }

    private fun createNewInspiringPerson() {
        val newInspiringPersonIntent = Intent(this,NewInspiringPersonActivity::class.java)
        startActivity(newInspiringPersonIntent)
    }


}