package com.example.surahyaseen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.databinding.SupplicationItemBinding
import com.example.surahyaseen.model.SupplicationModel

class SupplicationAdp(
    private val list: List<SupplicationModel>,
    private val callback: (SupplicationModel) -> Unit
) :
    RecyclerView.Adapter<SupplicationAdp.SupplicationVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplicationVH {
        val binding =
            SupplicationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SupplicationVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SupplicationVH, position: Int) {
        val model = list[position]
        holder.bind(model)
    }

    inner class SupplicationVH(private val binding: SupplicationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SupplicationModel) {
            binding.name.text = model.name
            binding.drawable.setImageResource(model.drawable)

            binding.card.setOnClickListener {
                callback(model)
            }
        }
    }
}