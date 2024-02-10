package com.example.surahyaseen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.databinding.NamesItemBinding
import com.example.surahyaseen.databinding.QalmaItemBinding
import com.example.surahyaseen.model.NamesModel
import com.example.surahyaseen.model.QalmaModel

class QalmaAdp :
    ListAdapter<QalmaModel, QalmaAdp.QalmaViewHolder>(customDiffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QalmaViewHolder {
        val binding = QalmaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QalmaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QalmaViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }


    inner class QalmaViewHolder(private val binding: QalmaItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: QalmaModel) {
            binding.qalmaName.text = model.qalma
            binding.qalmaArabic.text = model.arabicQalma
            binding.qalmaEng.text = model.meaning
        }
    }

    companion object {
        val customDiffUtils = object : DiffUtil.ItemCallback<QalmaModel>() {
            override fun areItemsTheSame(oldItem: QalmaModel, newItem: QalmaModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: QalmaModel, newItem: QalmaModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}