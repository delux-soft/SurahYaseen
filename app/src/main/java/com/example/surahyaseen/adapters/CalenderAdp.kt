package com.example.surahyaseen.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.model.CalenderCellModel
import com.example.surahyaseen.model.NumbersLocal
import com.example.surahyaseen.R
import com.example.surahyaseen.databinding.ItemCalenderCellBinding
import com.example.surahyaseen.model.CalenderHGDate


class CalenderAdp(
    private val context: Context,
    private val list: List<CalenderCellModel>,
    private val callback: (Int) -> Unit
) :
    RecyclerView.Adapter<CalenderAdp.CalenderVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderVH {

        val binding =
            ItemCalenderCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalenderVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CalenderVH, position: Int) {
        val model = list[position]
        holder.bind(model, position)
    }


    inner class CalenderVH(private val binding: ItemCalenderCellBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CalenderCellModel, position: Int) {
            if (model.isSelect) {
                binding.viewSelect.setBackgroundResource(R.drawable.bg_select)
            } else {
                binding.viewSelect.setBackgroundColor(0)
            }
            if (model.hijriDay == -1) {
                binding.tvDate.visibility = View.GONE
                binding.tvDateMuslim.visibility = View.GONE
            } else {
                binding.tvDate.visibility = View.VISIBLE
                binding.tvDateMuslim.visibility = View.VISIBLE
            }

            val hGDate = CalenderHGDate()
            if (model.georgianMonth == hGDate.getMonth() && model.georgianDay == hGDate.getDay() && model.georgianYear == hGDate.getYear()) {
                binding.tvDate.setTextColor(Color.parseColor("#017F01"))
                binding.tvDateMuslim.setTextColor(Color.parseColor("#017F01"))
                binding.viewBg.setBackgroundResource(R.drawable.bg_today)
            } else {
                binding.tvDate.setTextColor(Color.parseColor("#1C1B1F"))
                binding.tvDateMuslim.setTextColor(Color.parseColor("#1C1B1F"))
                binding.viewBg.setBackgroundResource(0)
            }
            binding.tvDate.text = NumbersLocal.convertNumberType(
                context,
                "${model.georgianDay} "
            )
            binding.tvDateMuslim.text = NumbersLocal.convertNumberType(
                context,
                "${model.hijriDay} "
            )


            binding.root.setOnClickListener {
                callback(position)
            }
        }
    }
}