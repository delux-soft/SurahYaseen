package com.example.surahyaseen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.surahyaseen.databinding.SupplicationInnerItem2Binding
import com.example.surahyaseen.databinding.SupplicationInnerItemBinding
import com.example.surahyaseen.model.SupplicationInnerModel

class SupplicationInnerAdp(
    private val itemType: Int,
    private val list: List<SupplicationInnerModel>, private val callback: (Int) -> Unit = {}
) :
    RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (itemType) {
            0 -> {
                val binding =
                    SupplicationInnerItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return SupplicationVH1(binding)
            }

            1 -> {
                val binding =
                    SupplicationInnerItem2Binding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return SupplicationVH2(binding)
            }

            else -> {
                val binding =
                    SupplicationInnerItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return SupplicationVH1(binding)
            }
        }


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        if (holder is SupplicationVH1) {
            holder.bind(model, position)
        } else if (holder is SupplicationVH2) {
            holder.bind(model)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    inner class SupplicationVH1(private val binding: SupplicationInnerItemBinding) :
        ViewHolder(binding.root) {
        fun bind(model: SupplicationInnerModel, position: Int) {
            binding.name.text = model.name
            binding.card.setOnClickListener {
                callback(position)
            }

        }

    }

    inner class SupplicationVH2(private val binding: SupplicationInnerItem2Binding) :
        ViewHolder(binding.root) {
        fun bind(model: SupplicationInnerModel) {
            binding.supplicationName.text = model.name
            binding.supplicationArabic.text = model.duaArabic
            binding.supplicationEng.text = model.duaEng
            binding.supplicationUrdu.text = model.duaUrdu
        }

    }
}