package com.example.surahyaseen.calenderUtils

import com.example.surahyaseen.calenderUtils.GregorianConverter.getDaysInMonth
import com.example.surahyaseen.calenderUtils.GregorianConverter.toGregorian
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.GregorianCalendar
import java.util.Locale
import java.util.TimeZone

class IslamicCalender(
    time: TimeZone = TimeZone.getDefault(),
    locale: Locale = Locale.getDefault(),
) : GregorianCalendar(time, locale) {


    constructor(i: Int, i2: Int, i3: Int) : this() {

    }


    private var hFields: IntArray? = null


    private fun lengthOfMonth(i: Int, i2: Int): Int {
        return getDaysInMonth(i, i2)
    }

    private fun lengthOfYear(i: Int): Int {
        var i2 = 0
        for (i3 in 0..11) {
            i2 += lengthOfMonth(i, i3)
        }
        return i2
    }

    override operator fun get(i: Int): Int {
        return if (i == 1 || i == 2 || i == 5) {
            hFields!![i]
        } else super.get(i)
    }

    override operator fun set(i: Int, i2: Int) {
        if (i == 1 || i == 2 || i == 5) {
            CoroutineScope(Dispatchers.Main).launch {
                val hijri: IntArray = GregorianConverter.toHijri(getTime())
                when (i) {
                    1 -> {
                        hijri[0] = i2
                    }
                    2 -> {
                        hijri[1] = i2
                    }
                    else -> {
                        hijri[2] = i2
                    }
                }
                val gregorian = toGregorian(hijri[0], hijri[1], hijri[2])
                super.set(1, gregorian[0])
                super.set(2, gregorian[1])
                super.set(5, gregorian[2])
                complete()
                return@launch
            }

        }
        super.set(i, i2)
    }

    fun lengthOfMonth(): Int {
        return lengthOfMonth(get(1), get(2))
    }

    fun lengthOfYear(): Int {
        return lengthOfYear(get(1))
    }

    override fun getDisplayName(i: Int, i2: Int, locale: Locale): String? {
        var i3 = 0
        if (i != 2) {
            return super.getDisplayName(i, i2, locale)
        }
        val fieldStrings = getFieldStrings(i, i2, UmmalquraDateFormatSymbols(locale))
        return if (fieldStrings == null || get(i).also { i3 = it } >= fieldStrings.size) {
            null
        } else fieldStrings[i3]
    }

    override fun getDisplayNames(i: Int, i2: Int, locale: Locale): Map<String, Int>? {
        if (i != 2) {
            return super.getDisplayNames(i, i2, locale)
        }
        if (i2 != 0) {
            return getDisplayNamesImpl(i, i2, locale)
        }
        val displayNamesImpl = getDisplayNamesImpl(i, 1, locale)
        val displayNamesImpl2: Map<String, Int>? = getDisplayNamesImpl(i, 2, locale)
        if (displayNamesImpl == null) {
            return displayNamesImpl2
        }
        if (displayNamesImpl2 != null) {
            displayNamesImpl.putAll(displayNamesImpl2)
        }
        return displayNamesImpl
    }

    private fun getDisplayNamesImpl(i: Int, i2: Int, locale: Locale): MutableMap<String, Int>? {
        val fieldStrings = getFieldStrings(i, i2, UmmalquraDateFormatSymbols(locale)) ?: return null
        val hashMap = HashMap<String, Int>()
        for (i3 in fieldStrings.indices) {
            if (fieldStrings[i3].isNotEmpty()) {
                hashMap[fieldStrings[i3]] = Integer.valueOf(i3)
            }
        }
        return hashMap
    }

    private fun getFieldStrings(
        i: Int,
        i2: Int,
        ummalquraDateFormatSymbols: UmmalquraDateFormatSymbols
    ): Array<String>? {
        if (i != 2) {
            return null
        }
        if (1 == i2) {
            return ummalquraDateFormatSymbols.getShortMonths()
        }
        return if (2 == i2) {
            ummalquraDateFormatSymbols.getMonths()
        } else null
    }

    override fun equals(obj: Any?): Boolean {
        return obj is IslamicCalender && super.equals(obj)
    }

    override fun hashCode(): Int {
        return super.hashCode() xor 622
    }

    /* access modifiers changed from: protected */
    override fun computeFields() {
        super.computeFields()
        if (hFields == null) {
            hFields = IntArray(this.fields.size)
        }
        val hijri: IntArray = GregorianConverter.toHijri(this.time)
        val iArr = hFields
        iArr!![1] = hijri[0]
        iArr[2] = hijri[1]
        iArr[5] = hijri[2]
    }
}