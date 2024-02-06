package com.example.surahyaseen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.databinding.SurahItemBinding
import com.example.surahyaseen.model.SurahModel

class SurahAdp(private val context: Context, private val list: List<SurahModel>) :
    RecyclerView.Adapter<SurahAdp.SurahVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahVH {
        val binding = SurahItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SurahVH, position: Int) {
        val model = list[position]
    }


    inner class SurahVH(private val binding: SurahItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}