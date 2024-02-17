package com.example.surahyaseen.calenderUtils

data class CalendarCell(
    val hijriDay: Int,
    val georgianDay: Int,
    val hijriMonth: Int,
    val georgianMonth: Int,
    val week: Int,
    val georgianYear: Int,
    var isSelect: Boolean = false
)