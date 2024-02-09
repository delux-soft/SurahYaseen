package com.example.surahyaseen.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.databinding.NamesItemBinding
import com.example.surahyaseen.model.NamesModel

class QalmaAdp :
    ListAdapter<NamesModel, QalmaAdp.QalmaViewHolder>(NameAdp.customDiffUtils) {

    inner class QalmaViewHolder(private val binding: NamesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: NamesModel) {





            binding.urduMeaning.text = model.urduMeaning
            binding.engBenefit.text = model.benefits

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QalmaViewHolder {

    }

    override fun onBindViewHolder(holder: QalmaViewHolder, position: Int) {

    }

}