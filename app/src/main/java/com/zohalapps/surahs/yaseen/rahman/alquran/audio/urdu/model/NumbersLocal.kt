package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.model

import android.content.Context
import androidx.exifinterface.media.ExifInterface

object NumbersLocal {
    fun convertNumberType(context: Context, str: String): String {
        try {
            if (context.resources.configuration.locale.displayLanguage == "العربية") {
                return str.replace("0".toRegex(), "٠").replace("1".toRegex(), "١")
                    .replace(ExifInterface.GPS_MEASUREMENT_2D.toRegex(), "٢").replace(
                        ExifInterface.GPS_MEASUREMENT_3D.toRegex(), "٣"
                    ).replace("4".toRegex(), "٤").replace("5".toRegex(), "٥")
                    .replace("6".toRegex(), "٦").replace("7".toRegex(), "٧")
                    .replace("8".toRegex(), "٨").replace("9".toRegex(), "٩")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return str
    }



}