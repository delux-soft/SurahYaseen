package com.example.surahyaseen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.surahyaseen.R
import com.example.surahyaseen.adapters.CalenderAdp
import com.example.surahyaseen.calenderUtils.CalendarCell
import com.example.surahyaseen.databinding.FragmentCalenderBinding
import com.example.surahyaseen.model.Dates
import com.example.surahyaseen.model.HGDate
import com.example.surahyaseen.model.NumbersLocal


private const val TAG = "CalenderFragmentXX"

class CalenderFragment : Fragment() {
    private var _calenderBinding: FragmentCalenderBinding? = null
    private val calenderBinding get() = _calenderBinding!!

    private lateinit var adapter: CalenderAdp

    private var mainMonth: Int = 0
    private var mainYear: Int = 0
    private val monthList: ArrayList<CalendarCell> = ArrayList()



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

    }


    private fun setup() {
        adapter = CalenderAdp(requireContext(), monthList) { position ->
            val clickedCell = monthList[position]
            if (clickedCell.georgianDay != -1) {

                getTitleDay(clickedCell.georgianDay)
            }
        }

        calenderBinding.calenderRecycler.isNestedScrollingEnabled = false
        calenderBinding.calenderRecycler.layoutManager = GridLayoutManager(requireContext(), 7)
        calenderBinding.calenderRecycler.adapter = adapter
        loadGregorianCalendar(HGDate())

        calenderBinding.btLeft.setOnClickListener {
            decreaseMonth()
        }

        calenderBinding.btRight.setOnClickListener {
            increaseMonth()
        }
    }

    private fun decreaseMonth() {
        mainMonth--
        if (mainMonth <= 0) {
            mainMonth = 12
            mainYear--
        }
        loadMonthsDayGregorian(mainMonth, mainYear)
    }

    private fun increaseMonth() {
        mainMonth++
        if (mainMonth > 12) {
            mainMonth = 1
            mainYear++
        }
        loadMonthsDayGregorian(mainMonth, mainYear)
    }

    private fun loadGregorianCalendar(hgDate: HGDate) {
        mainMonth = hgDate.month
        mainYear = hgDate.year
        loadMonthsDayGregorian(hgDate.month, hgDate.year)
    }

    private fun loadMonthsDayGregorian(month: Int, year: Int) {
        monthList.clear()
        var spaceSet = false
        var isFirstDaySelected = false
        var space = 0

        val currentDate = HGDate()
        currentDate.setGregorian(year, month, 1)

        while (month == currentDate.month) {
            val calendarCell = CalendarCell(
                currentDate.dayHigri,
                currentDate.day,
                currentDate.monthHigri,
                currentDate.month,
                currentDate.weekDay(),
                currentDate.year
            )
            if (!spaceSet) {
                space = currentDate.weekDay() - 1
                spaceSet = true
            }
            if (!isFirstDaySelected) {
                if (calendarCell.georgianMonth == currentDate.month && calendarCell.georgianDay == currentDate.day && calendarCell.georgianYear == currentDate.year) {
                    getTitleDay(currentDate.day)
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
            monthList.add(0, CalendarCell(-1, -1, -1, -1, -1, -1))
        }

        adapter.notifyDataSetChanged()
    }

    private fun getTitleDay(day: Int) {
        val currentDate = HGDate()
        currentDate.setGregorian(mainYear, mainMonth, day)

        val gregorianText = getString(
            R.string.gregorian_date_format,
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.day}"),
            Dates.gregorianMonthName(requireContext(), currentDate.month - 1),
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.year}")
        )
        calenderBinding.tvMonth.text = gregorianText

        currentDate.toHigri()
        val islamicText = getString(
            R.string.islamic_date_format,
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.dayHigri}").trim(),
            Dates.islamicMonthName(requireContext(), currentDate.monthHigri - 1).trim(),
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.yearHigri}")
        )
        calenderBinding.tvMonthMuslim.text = islamicText
    }



}