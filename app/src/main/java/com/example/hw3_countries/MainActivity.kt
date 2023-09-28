package com.example.hw3_countries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw3_countries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mData = CountryCodes.countryCodes.toMutableList()
    private val countriesAdapter = CountriesAdapter(mData)
    private val itemTouchHelperAdapter = countriesAdapter.itemTouchHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = countriesAdapter
        itemTouchHelperAdapter.attachToRecyclerView(binding.recyclerView)
    }


}