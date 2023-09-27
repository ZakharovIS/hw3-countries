package com.example.hw3_countries

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
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