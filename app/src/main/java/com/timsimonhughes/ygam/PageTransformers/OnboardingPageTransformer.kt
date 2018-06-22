package com.timsimonhughes.ygam.PageTransformers

import android.support.constraint.ConstraintLayout
import android.support.v4.view.ViewPager
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.timsimonhughes.ygam.R
import android.opengl.ETC1.getWidth



/**
 * Created by thu01 on 04/06/2018.
 */
class OnboardingPageTransformer : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {

        val pageWidth = page.width
        val pageWidthTimesPosition =  pageWidth * position
        val absPosition = Math.abs(position)

        if (position <= -1.0f || position >= 1.0f) {
            // Page is not visible -- stop runnning any animations
        } else if (position == 0.0f) {
            // Page is selected -- reset any views if necessary
        } else {

            val fragmentCard1 = page.findViewById<ConstraintLayout>(R.id.fragmentCard1)
            fragmentCard1?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 1.0f
            }

            val circleCenter = page.findViewById<ImageView>(R.id.circleCenter)
            circleCenter?.apply {
                scaleX = 1.0f - absPosition * 2
                scaleY = 1.0f - absPosition * 2
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 0.4f
            }

            val taskcard = page.findViewById<RelativeLayout>(R.id.top)
            taskcard?.apply {
                translationX = pageWidthTimesPosition * 0.6f
            }

            val taskCard2 = page.findViewById<RelativeLayout>(R.id.middle)
            taskCard2?.apply {
                translationX = pageWidthTimesPosition * 0.8f
            }

            val taskCard3 = page.findViewById<RelativeLayout>(R.id.bottom)
            taskCard3?.apply {
                translationX = pageWidthTimesPosition * 1.0f
            }


        }
    }

}