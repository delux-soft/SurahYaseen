package com.example.surahyaseen.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surahyaseen.R
import com.example.surahyaseen.calenderUtils.CalendarCell
import com.example.surahyaseen.databinding.CalenderItemBinding
import com.example.surahyaseen.model.HGDate
import com.example.surahyaseen.model.NumbersLocal


class CalenderAdp(
    private val context: Context,
    private val list: List<CalendarCell>,
    private val callback: (Int) -> Unit
) :
    RecyclerView.Adapter<CalenderAdp.CalenderVH>() {

    private var index = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderVH {
        val binding =
            CalenderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalenderVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CalenderVH, position: Int) {
        val model = list[position]
        holder.bind(model, position)
    }


    inner class CalenderVH(private val binding: CalenderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(calendarCell: CalendarCell, position: Int) {


            if (calendarCell.isSelect) {
                binding.viewBg.setBackgroundResource(R.drawable.bg_today)
            } else {
                binding.viewBg.setBackgroundResource(0)
            }
            if (calendarCell.hijriDay == -1) {
                binding.tvDate.visibility = View.GONE
                binding.tvDateMuslim.visibility = View.GONE
            } else {
                binding.tvDate.visibility = View.VISIBLE
                binding.tvDateMuslim.visibility = View.VISIBLE
            }

            val hGDate = HGDate()
            if (calendarCell.georgianMonth == hGDate.month && calendarCell.georgianDay == hGDate.day && calendarCell.georgianYear == hGDate.year) {
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
                "${calendarCell.georgianDay} "
            )
            binding.tvDateMuslim.text = NumbersLocal.convertNumberType(
                context,
                "${calendarCell.hijriDay}"
            )
            binding.viewSelect.setOnClickListener {


                if (index != -1) {
                    list[index].isSelect = false
                    notifyItemChanged(index)
                }
                calendarCell.isSelect = true
                notifyItemChanged(position)
                index = position

                callback(position)
            }
        }
    }
}