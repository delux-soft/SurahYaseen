package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.QulModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.QulItemBinding

class QulAdp(private val list: List<QulModel>) : RecyclerView.Adapter<QulAdp.QulVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QulVH {
        val binding = QulItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QulVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: QulVH, position: Int) {
        val model = list[position]
        holder.bind(model)
    }


    inner class QulVH(private val binding: QulItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: QulModel) {
            binding.qalmaArabic.text = model.qulArabic
            binding.qulName.text = model.qulName
            binding.qalmaEng.text = model.engMeaning
        }

    }
}