package com.example.surahyaseen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.surahyaseen.databinding.SupplicationInnerItemBinding
import com.example.surahyaseen.model.SupplicationInnerModel

class SupplicationInnerAdp(
    private val itemType: Int,
    private val list: List<SupplicationInnerModel>
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
                    SupplicationInnerItemBinding.inflate(
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
        if (holder is SupplicationVH1) {
        } else if (holder is SupplicationVH2) {
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }


    inner class SupplicationVH1(private val binding: SupplicationInnerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SupplicationInnerModel) {
            binding.name.text = model.name
        }

    }

    inner class SupplicationVH2(private val binding: SupplicationInnerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SupplicationInnerModel) {
            binding.name.text = model.name
        }

    }
}