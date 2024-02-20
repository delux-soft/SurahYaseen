package com.example.surahyaseen.model

import android.content.Context
import com.example.surahyaseen.activities.string
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Dates {

    fun islamicMonthName(context: Context, i: Int): String {
        return when (i) {
            0 -> context.resources.getString(string.month1)
            1 -> context.resources.getString(string.month2)
            2 -> context.resources.getString(string.month3)
            3 -> context.resources.getString(string.month4)
            4 -> context.resources.getString(string.month5)
            5 -> context.resources.getString(string.month6)
            6 -> context.resources.getString(string.month7)
            7 -> context.resources.getString(string.month8)
            8 -> context.resources.getString(string.month9)
            9 -> context.resources.getString(string.month10)
            10 -> context.resources.getString(string.month11)
            else -> context.resources.getString(string.month12)
        }
    }


    fun gregorianMonthName(context: Context, i: Int): String {
        return when (i) {
            0 -> context.resources.getString(string.month1g)
            1 -> context.resources.getString(string.month2g)
            2 -> context.resources.getString(string.month3g)
            3 -> context.resources.getString(string.month4g)
            4 -> context.resources.getString(string.month5g)
            5 -> context.resources.getString(string.month6g)
            6 -> context.resources.getString(string.month7g)
            7 -> context.resources.getString(string.month8g)
            8 -> context.resources.getString(string.month9g)
            9 -> context.resources.getString(string.month10g)
            10 -> context.resources.getString(string.month11g)
            else -> context.resources.getString(string.month12g)
        }
    }




}