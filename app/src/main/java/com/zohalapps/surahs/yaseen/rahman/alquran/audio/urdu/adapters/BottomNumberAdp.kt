package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.BottomNumberItemBinding

class BottomNumberAdp(private val list: List<Int>, private val callback: (Int) -> Unit) :
    RecyclerView.Adapter<BottomNumberAdp.BottomNumberVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomNumberVH {
        val binding =
            BottomNumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BottomNumberVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BottomNumberVH, position: Int) {
        val text = list[position]
        holder.bind(text, position)
    }



    inner class BottomNumberVH(private val binding: BottomNumberItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Int, position: Int) {

            binding.text.text = model.toString()
            binding.root.setOnClickListener {
                callback(position)
            }
        }

    }

}