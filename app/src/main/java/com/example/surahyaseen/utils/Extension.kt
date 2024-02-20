package com.example.surahyaseen.utils

import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

object Extension {

    fun ViewPager2.addCarouselEffect(enableZoom: Boolean = true) {
        clipChildren = false    // No clipping the left and right items
        clipToPadding = false   // Show the viewpager in full width without clipping the padding
        offscreenPageLimit = 3  // Render the left and right items


        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((20 * Resources.getSystem().displayMetrics.density).toInt()))
        if (enableZoom) {
            compositePageTransformer.addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = (0.80f + r * 0.20f)
            }
        }
        setPageTransformer(compositePageTransformer)
    }

}