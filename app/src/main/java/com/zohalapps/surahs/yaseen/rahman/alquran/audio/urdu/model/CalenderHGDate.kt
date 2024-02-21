package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model

import android.icu.util.IslamicCalendar
import java.util.Calendar
import java.util.GregorianCalendar

class CalenderHGDate() {


    private var calendar: Calendar = Calendar.getInstance()
    private var day: Int = 0
    private var dayHijri: Int = 0
    private var month: Int = 0
    private var monthHijri: Int = 0
    private var year: Int = 0
    private var yearHijri: Int = 0



    init {
        getDate(calendar)
    }

    private fun getDate(calendar: Calendar) {
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH) + 1
        year = calendar.get(Calendar.YEAR)
        val gregorianCalendar = GregorianCalendar(year, month - 1, day)
        val ummalquraCalendar = IslamicCalendar()
        ummalquraCalendar.time = gregorianCalendar.time
        dayHijri = ummalquraCalendar.get(Calendar.DAY_OF_MONTH)
        monthHijri = ummalquraCalendar.get(Calendar.MONTH) + 1
        yearHijri = ummalquraCalendar.get(Calendar.YEAR)

    }



    fun setGregorian(year: Int, month: Int, day: Int) {
        this.day = day
        this.month = month
        this.year = year
        val gregorianCalendar = GregorianCalendar(year, month - 1, day)
        val ummalquraCalendar = IslamicCalendar()
        ummalquraCalendar.time = gregorianCalendar.time
        dayHijri = ummalquraCalendar.get(Calendar.DAY_OF_MONTH)
        monthHijri = ummalquraCalendar.get(Calendar.MONTH) + 1
        yearHijri = ummalquraCalendar.get(Calendar.YEAR)
        calendar.set(this.year, this.month - 1, this.day)
    }


    fun getDay(): Int {
        return day
    }

    fun getMonth(): Int {
        return month
    }

    fun getYear(): Int {
        return year
    }

    fun getDayHijri(): Int {
        return dayHijri
    }

    fun getMonthHijri(): Int {
        return monthHijri
    }

    fun getYearHijri(): Int {
        return yearHijri
    }

    fun weekDay(): Int {
        return calendar.get(Calendar.DAY_OF_WEEK)
    }

    fun nextDay() {
        calendar.add(Calendar.DAY_OF_MONTH, 1)
        getDate(calendar)
    }


    override fun toString(): String {
        return "$dayHijri/$monthHijri/$yearHijri"
    }


}