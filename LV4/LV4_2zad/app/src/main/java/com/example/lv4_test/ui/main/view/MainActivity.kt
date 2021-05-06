package com.example.lv4_test.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lv4_test.R
import com.example.lv4_test.data.api.ApiHelper
import com.example.lv4_test.data.api.ApiServiceImpl
import com.example.lv4_test.data.model.User
import com.example.lv4_test.databinding.ActivityMainBinding
import com.example.lv4_test.ui.base.ViewModelFactory
import com.example.lv4_test.ui.main.adapter.MainAdapter
import com.example.lv4_test.ui.main.viewmodel.MainViewModel
import com.example.lv4_test.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)


        setupUI()
        setupViewModel()
        setupObserver()

        setContentView(mainBinding.root)

    }

    private fun setupUI() {
        mainBinding.recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter = MainAdapter(arrayListOf())

        mainBinding.recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when(it.status){
                //ako je dohvaćanje uspješno
                Status.SUCCESS -> {
                    mainBinding.progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    mainBinding.recyclerView.visibility = View.VISIBLE
                }

                //ako se i dalje učitava
                Status.LOADING -> {
                    mainBinding.progressBar.visibility = View.VISIBLE
                    mainBinding.recyclerView.visibility = View.GONE
                }

                //ako je pri učitavanju došlo do pogreške
                Status.ERROR -> {
                    mainBinding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG)
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }




}