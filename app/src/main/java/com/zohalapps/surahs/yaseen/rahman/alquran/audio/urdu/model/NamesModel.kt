package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model

data class NamesModel(
    val englishName: String,
    val arabicName: String,
    val engMeaning: String,
    val urduMeaning: String,
    val benefits: String,
    val engDesc: String = "", var isExpanded: Boolean = false
)
