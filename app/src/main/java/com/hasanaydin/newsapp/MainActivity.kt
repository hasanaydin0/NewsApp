package com.hasanaydin.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hasanaydin.newsapp.api.MainViewModel
import com.hasanaydin.newsapp.databinding.ActivityMainBinding
import com.hasanaydin.newsapp.databinding.AdapterBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding
    lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = Adapter(listOf())
        binding.recyclerNews.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.gam()


        viewModel.livedata.observe(this, Observer {

            adapter.dataList = it.articles
            adapter.notifyDataSetChanged()

        })
    }

    
}