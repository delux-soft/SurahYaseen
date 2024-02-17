package com.example.surahyaseen.calenderUtils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import java.util.Date
import kotlin.math.floor

object GregorianConverter {


    private fun getNewMoonMJDNIndex(i: Int, i2: Int): Int {
        return (i - 1) * 12 + 1 + (i2 - 1) - 16260
    }

    @JvmStatic
     fun toHijri(j: Long): IntArray {
        return toHijri(Date(j))
    }

    @JvmStatic
     fun toHijri(date: Date): IntArray {
        val instance = Calendar.getInstance()
        instance.time = date
        val d2h = d2h(g2d(instance[1], instance[2] + 1, instance[5]))
        d2h[1] = d2h[1] - 1
        return d2h
    }

    suspend fun toHijri(i: Int, i2: Int, i3: Int): IntArray {
        val d2h = d2h(g2d(i, i2 + 1, i3))
        d2h[1] = d2h[1] - 1
        return d2h
    }

    @JvmStatic
    suspend fun toGregorian(i: Int, i2: Int, i3: Int): IntArray {
        val d2g = d2g(h2d(i, i2 + 1, i3))
        d2g[1] = d2g[1] - 1
        return d2g
    }

    private fun div(i: Int, i2: Int): Int {
        return (i / i2).inv().inv()
    }

    private fun mod(i: Int, i2: Int): Int {
        return i - (i / i2).inv().inv() * i2
    }


    @JvmStatic
    fun getDaysInMonth(i: Int, i2: Int): Int {
        val newMoonMJDNIndex = getNewMoonMJDNIndex(i, i2 + 1)
        return ummalquraData(newMoonMJDNIndex) - ummalquraData(newMoonMJDNIndex - 1)
    }

    private suspend fun h2d(i: Int, i2: Int, i3: Int): Int {
        return i3 + ummalquraData(getNewMoonMJDNIndex(i, i2) - 1) - 1 + 2400000
    }

    private suspend fun d2h(i: Int): IntArray {
        val i2 = i - 2400000
        val newMoonMJDNIndexByJDN = getNewMoonMJDNIndexByJDN(i2)
        val i3 = newMoonMJDNIndexByJDN + 16260
        val floor = floor(((i3 - 1) / 12).toDouble()).toInt()
        return intArrayOf(
            floor + 1,
            i3 - floor * 12,
            i2 - ummalquraData(newMoonMJDNIndexByJDN - 1) + 1
        )
    }

    private fun g2d(i: Int, i2: Int, i3: Int): Int {
        val i4 = i2 - 8
        return div((div(i4, 6) + i + 100100) * 1461, 4) + div(
            mod(i2 + 9, 12) * 153 + 2,
            5
        ) + i3 - 34840408 - div(
            div(
                i + 100100 + div(i4, 6), 100
            ) * 3, 4
        ) + 752
    }

    private fun d2g(i: Int): IntArray {
        val i2 = i * 4
        val div = 139361631 + i2 + div(div(i2 + 183187720, 146097) * 3, 4) * 4 - 3908
        val div2 = div(mod(div, 1461), 4) * 5 + 308
        val mod = mod(div(div2, 153), 12) + 1
        return intArrayOf(
            div(div, 1461) - 100100 + div(8 - mod, 6),
            mod,
            div(mod(div2, 153), 5) + 1
        )
    }

    private suspend fun getNewMoonMJDNIndexByJDN(i: Int): Int {
        var i2 = 0
        while (true) {
            val iArr = CalenderRepo.getData()

            if (i2 >= iArr.size) {
                return -1
            }
            if (iArr[i2] > i) {
                return i2
            }
            i2++
        }
    }

    private fun ummalquraData(i: Int): Int {
        if (i >= 0) {
            val iArr = CalenderRepo.getData()


            if (i < iArr.size) {
                return iArr[i]
            }
        }
        throw IllegalArgumentException("Valid date should be between 1356 AH (14 March 1937 CE) to 1500 AH (16 November 2077 CE)")
    }
}