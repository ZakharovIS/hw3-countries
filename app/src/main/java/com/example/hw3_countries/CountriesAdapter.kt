package com.example.hw3_countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw3_countries.databinding.ItemCountryBinding
import java.util.Collections

class CountriesAdapter(private var data: MutableList<Pair<String, String>>) :
    RecyclerView.Adapter<CountriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context))
        return CountriesViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val item = data[position]
        val url = "https://flagcdn.com/256x192/" + item.first + ".png"
        Glide.with(holder.binding.root.context)
            .load(url)
            .into(holder.binding.countryFlag)
        holder.binding.countryId.text = item.first
        holder.binding.countryName.text = item.second
    }

    val itemTouchHelper = ItemTouchHelper(
        object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP
                    or ItemTouchHelper.DOWN
                    or ItemTouchHelper.LEFT
                    or ItemTouchHelper.RIGHT,
            0
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                Collections.swap(data, viewHolder.adapterPosition, target.adapterPosition)
                recyclerView.adapter?.notifyItemMoved(
                    viewHolder.adapterPosition,
                    target.adapterPosition
                )
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }

        }
    )

}

class CountriesViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root)


