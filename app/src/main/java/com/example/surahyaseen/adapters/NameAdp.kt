package com.example.surahyaseen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.databinding.NamesItemBinding
import com.example.surahyaseen.model.NamesModel

class NameAdp :
    ListAdapter<NamesModel, NameAdp.NamesViewHolder>(customDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {

        val binding = NamesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }

    inner class NamesViewHolder(private val binding: NamesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: NamesModel) {

            val meaning = model.engMeaning
            val halfMeaning = returnArrangedText(meaning, 30)

            binding.arabicName.text = model.arabicName
            binding.engName.text = model.englishName
            if (halfMeaning.isEmpty()) {
                binding.engMeaning.text = model.engMeaning
            } else {
                binding.engMeaning.text = halfMeaning
            }

            binding.urduMeaning.text = model.urduMeaning
            binding.engBenefit.text = model.benefits

        }


        private fun returnArrangedText(meaning: String, index: Int = 30): String {
            var halfMeaning = ""
            if (meaning.length > index) {
                val lastSpaceIndex =
                    meaning.lastIndexOf(
                        ' ',
                        index
                    ) // Find the last space within the first 30 characters
                if (lastSpaceIndex != -1) {
                    halfMeaning = meaning.substring(0, lastSpaceIndex)
                    halfMeaning += "\n" // Use "\n" to insert a newline character
                    halfMeaning += meaning.substring(lastSpaceIndex + 1) // Start after the space
                } else {
                    // If no space found, just break at the 30th character
                    halfMeaning = meaning.substring(0, index)
                    halfMeaning += "\n"
                    halfMeaning += meaning.substring(index)
                }
            }
            return halfMeaning
        }

    }

    companion object {
        val customDiffUtils = object : DiffUtil.ItemCallback<NamesModel>() {
            override fun areItemsTheSame(oldItem: NamesModel, newItem: NamesModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NamesModel, newItem: NamesModel): Boolean {
                return oldItem == newItem
            }
        }
    }


}