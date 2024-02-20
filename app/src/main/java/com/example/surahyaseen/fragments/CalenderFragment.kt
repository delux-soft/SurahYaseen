package com.example.surahyaseen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.surahyaseen.model.CalenderCellModel
import com.example.surahyaseen.model.NumbersLocal
import com.example.surahyaseen.R
import com.example.surahyaseen.adapters.CalenderAdp
import com.example.surahyaseen.databinding.FragmentCalenderBinding
import com.example.surahyaseen.model.CalenderHGDate
import com.example.surahyaseen.model.Dates


class CalenderFragment : Fragment() {
    private var _calenderBinding: FragmentCalenderBinding? = null
    private val calenderBinding get() = _calenderBinding!!

    private lateinit var adapter: CalenderAdp

    private var mainMonth: Int = 0
    private var mainYear: Int = 0
    private val monthList: ArrayList<CalenderCellModel> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _calenderBinding = FragmentCalenderBinding.inflate(inflater, container, false)
        return calenderBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        calenderBinding.calenderHeader.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }


    private fun setup() {
        adapter = CalenderAdp(requireContext(), monthList) { position ->
            if (monthList[position].georgianDay != -1) {
                for (i2 in monthList.indices) {
                    if (monthList[i2].isSelect) {
                        monthList[i2].isSelect = false
                        adapter.notifyItemChanged(i2)
                    }
                }
                monthList[position].isSelect = true
                adapter.notifyItemChanged(position)
                getTitleDay(monthList[position].georgianDay)
            }
        }

        calenderBinding.calenderRecycler.isNestedScrollingEnabled = false
        calenderBinding.calenderRecycler.layoutManager = GridLayoutManager(requireContext(), 7)
        calenderBinding.calenderRecycler.adapter = adapter
        loadGregorianCalendar(CalenderHGDate())

        calenderBinding.btLeft.setOnClickListener {
            prev()
        }

        calenderBinding.btRight.setOnClickListener {
            next()
        }
    }

    private fun prev() {
        mainMonth--
        if (mainMonth <= 0) {
            mainMonth = 12
            mainYear--
        }
        loadMonthsDayGregorian(mainMonth, mainYear)
    }

    private fun next() {
        mainMonth++
        if (mainMonth > 12) {
            mainMonth = 1
            mainYear++
        }
        loadMonthsDayGregorian(mainMonth, mainYear)
    }

    private fun loadGregorianCalendar(hgDate: CalenderHGDate) {
        mainMonth = hgDate.getMonth()
        mainYear = hgDate.getYear()
        loadMonthsDayGregorian(hgDate.getMonth(), hgDate.getYear())
    }

    private fun loadMonthsDayGregorian(month: Int, year: Int) {
        monthList.clear()
        var spaceSet = false
        var isFirstDaySelected = false
        var space = 0

        val currentDate = CalenderHGDate()
        currentDate.setGregorian(year, month, 1)

        while (month == currentDate.getMonth()) {
            val calendarCell = CalenderCellModel(
                currentDate.getDayHijri(),
                currentDate.getDay(),
                currentDate.getMonthHijri(),
                currentDate.getMonth(),
                currentDate.weekDay(),
                currentDate.getYear()
            )
            if (!spaceSet) {
                space = currentDate.weekDay() - 1
                spaceSet = true
            }
            if (!isFirstDaySelected) {
                if (calendarCell.georgianMonth == currentDate.getMonth() && calendarCell.georgianDay == currentDate.getDay() && calendarCell.georgianYear == currentDate.getYear()) {
                    getTitleDay(currentDate.getDay())
                    calendarCell.isSelect = true
                    isFirstDaySelected = true
                }
            }
            monthList.add(calendarCell)
            currentDate.nextDay()
        }

        if (!isFirstDaySelected) {
            getTitleDay(1)
            monthList[0].isSelect = true
        }

        repeat(space) {
            monthList.add(0, CalenderCellModel(-1, -1, -1, -1, -1, -1))
        }

        adapter.notifyDataSetChanged()
    }

    private fun getTitleDay(day: Int) {
        val currentDate = CalenderHGDate()
        currentDate.setGregorian(mainYear, mainMonth, day)

        val gregorianText = getString(
            R.string.gregorian_date_format,
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getDay()}"),
            Dates.gregorianMonthName(requireContext(), currentDate.getMonth() - 1),
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getYear()}")
        )
        calenderBinding.tvMonth.text = gregorianText

        val islamicText = getString(
            R.string.islamic_date_format,
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getDayHijri()}").trim(),
            Dates.islamicMonthName(requireContext(), currentDate.getMonthHijri() - 1).trim(),
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getYearHijri()}")
        )
        calenderBinding.tvMonthMuslim.text = islamicText
    }


}