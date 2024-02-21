package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model

data class CalenderCellModel(
    val hijriDay: Int,
    val georgianDay: Int,
    val hijriMonth: Int,
    val georgianMonth: Int,
    val week:Int,
    val georgianYear: Int,
    var isSelect: Boolean = false,
)