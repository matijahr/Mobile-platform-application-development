package com.example.inspiringpersons.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersons.MainActivity
import com.example.inspiringpersons.R
import com.example.inspiringpersons.adapters.InspiringPersonAdapter
import com.example.inspiringpersons.databinding.ActivityNewInspiringPersonBinding
import com.example.inspiringpersons.models.InspiringPerson
import com.example.inspiringpersons.persistence.PersonsRepository
import kotlin.random.Random


class NewInspiringPersonActivity :AppCompatActivity() {
    private lateinit var newInspiringPersonBinding: ActivityNewInspiringPersonBinding
    private val KEY_MESSAGE: String = "message"
    private val ERROR_MESSAGE: String = "You have to fill all the required fields"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newInspiringPersonBinding = ActivityNewInspiringPersonBinding.inflate(layoutInflater)
        newInspiringPersonBinding.bCommitNewInspiringPerson.setOnClickListener{insertNewPerson()}
        setContentView(newInspiringPersonBinding.root)
    }

    private fun insertNewPerson() {

        try {
            val newPerson = InspiringPerson(
                    newInspiringPersonBinding.etNewInspiringPersonNameInput.text.toString(),
                    newInspiringPersonBinding.etNewInspiringPersonDescriptionInput.text.toString(),
                    newInspiringPersonBinding.etNewInspiringPersonDoBInput.text.toString(),
                    newInspiringPersonBinding.etNewInspiringPersonQuoteInput.text.toString(),
                    newInspiringPersonBinding.etNewInspiringPersonPictureInput.text.toString()
            )

            if (newPerson.name.isBlank() && newPerson.description.isBlank() && newPerson.DoB.isBlank() && newPerson.image.isBlank()){
                throw Exception(ERROR_MESSAGE)
            }

            val putPersonToMain = Intent(this, MainActivity::class.java)
            putPersonToMain.putExtra(KEY_MESSAGE, newPerson)
            startActivity(putPersonToMain)

        }catch (e: Exception){
            Toast.makeText(this, e.message,Toast.LENGTH_LONG).show()
        }


    }
}


