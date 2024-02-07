package com.example.surahyaseen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.databinding.NamesItemBinding

class NameAdp(private val list: List<String>) : RecyclerView.Adapter<NameAdp.NameVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameVH {
        val binding = NamesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NameVH, position: Int) {

    }

    inner class NameVH(private val binding: NamesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }

    }
}