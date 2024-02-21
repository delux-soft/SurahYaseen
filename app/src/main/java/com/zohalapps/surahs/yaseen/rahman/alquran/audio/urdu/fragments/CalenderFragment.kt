package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdView
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.activities.string
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.CalenderCellModel
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.NumbersLocal
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.adapters.CalenderAdp
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.ads.BannerAd
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.CalenderHGDate
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model.Dates
import com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.databinding.FragmentCalenderBinding


class CalenderFragment : Fragment() {
    private var _calenderBinding: FragmentCalenderBinding? = null
    private val calenderBinding get() = _calenderBinding!!

    private lateinit var adapter: CalenderAdp

    private var mainMonth: Int = 0
    private var mainYear: Int = 0
    private val monthList: ArrayList<CalenderCellModel> = ArrayList()

    private val banner by lazy {
        BannerAd(requireContext(), lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _calenderBinding = FragmentCalenderBinding.inflate(inflater, container, false)
        calenderBinding.root.doOnPreDraw {
            showAd()
        }
        return calenderBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        bindListener()

    }

    private fun showAd() {
        banner.loadBanner {
            showBannerAd(it)
        }
    }

    private fun showBannerAd(adView: AdView) {
        if (adView.parent != null) {
            (adView.parent as ViewGroup).removeView(adView)
        }
        calenderBinding.calenderBanner.ad.visibility = View.GONE
        calenderBinding.calenderBanner.advertisement.visibility = View.GONE
        calenderBinding.calenderBanner.bannerContainer.addView(adView)
    }

    private fun bindListener() {
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
            string.gregorian_date_format,
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getDay()}"),
            Dates.gregorianMonthName(requireContext(), currentDate.getMonth() - 1),
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getYear()}")
        )
        calenderBinding.tvMonth.text = gregorianText

        val islamicText = getString(
            string.islamic_date_format,
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getDayHijri()}").trim(),
            Dates.islamicMonthName(requireContext(), currentDate.getMonthHijri() - 1).trim(),
            NumbersLocal.convertNumberType(requireContext(), "${currentDate.getYearHijri()}")
        )
        calenderBinding.tvMonthMuslim.text = islamicText
    }


}