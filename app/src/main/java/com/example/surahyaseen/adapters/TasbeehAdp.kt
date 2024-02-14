package com.example.surahyaseen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.databinding.TasbeehItemBinding
import com.example.surahyaseen.model.TasbeehModel

class TasbeehAdp(private val list: List<TasbeehModel>) :
    RecyclerView.Adapter<TasbeehAdp.TasbeehVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasbeehVH {
        val binding = TasbeehItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TasbeehVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TasbeehVH, position: Int) {
        val model = list[position]
        holder.bind(model)
    }

    fun changeValue(position: Int) {
        ++list[position].value
        notifyItemChanged(position)
    }

    fun reset(position: Int) {
        list[position].value = 0
        notifyItemChanged(position)
    }

    inner class TasbeehVH(private val binding: TasbeehItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: TasbeehModel) {
            binding.name.text = model.name
            binding.number.text = model.value.toString()
        }
    }
}