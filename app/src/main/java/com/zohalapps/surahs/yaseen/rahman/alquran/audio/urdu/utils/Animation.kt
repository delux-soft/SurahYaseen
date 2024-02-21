package com.zohalapps.surahs.yaseen.rahman.alquran.audio.urdu.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.view.View

object Animation {

    private var shortAnimationDuration: Int = 0
     fun crossFade(context: Context, viewToShow: View, viewToHide: View) {
        shortAnimationDuration = context.resources.getInteger(android.R.integer.config_shortAnimTime)
        viewToShow.apply {
            // Set the content view to 0% opacity but visible, so that it is
            // visible but fully transparent during the animation.
            alpha = 0f
            visibility = View.VISIBLE

            // Animate the content view to 100% opacity and clear any animation
            // listener set on the view.
            animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)
        }
        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step so it doesn't
        // participate in layout passes.
        viewToHide.animate()
            .alpha(0f)
            .setDuration(shortAnimationDuration.toLong())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    viewToHide.visibility = View.INVISIBLE
                }
            })
    }
}