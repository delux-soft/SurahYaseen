package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.BottomNumberItemBinding
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.NumberModel

class BottomNumberAdp(private val list: List<NumberModel>) :
    RecyclerView.Adapter<BottomNumberAdp.BottomNumberVH>() {
    private var index = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomNumberVH {
        val binding =
            BottomNumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BottomNumberVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BottomNumberVH, position: Int) {
        val model = list[position]
        holder.bind(model)
    }

    fun selectPosition(position: Int) {
        if (index != -1) {
            list[index].isSelected = false
            notifyItemChanged(index)
        }
        index = position
        list[index].isSelected = true
        notifyItemChanged(position)
    }

    inner class BottomNumberVH(private val binding: BottomNumberItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: NumberModel) {
            if (model.isSelected){
                binding.text.isActivated = true
                binding.text.setPadding(20, 15, 20, 15)
            }
            else{
                binding.text.isActivated = false
                binding.text.setPadding(20, 15, 20, 15)
            }

            binding.text.text = model.number.toString()

        }

    }

}