package com.timsimonhughes.ygam.pageTransformers

import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import com.timsimonhughes.ygam.R
import com.timsimonhughes.ygam.R.id.fragment2Subcopy

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

            val frame1Title = page.findViewById<TextView>(R.id.fragment1Title)
            frame1Title?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 1.0f
            }

            val frame1Subcopy = page.findViewById<TextView>(R.id.fragment1Subcopy)
            frame1Subcopy?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 0.6f
            }

            val frame1Image = page.findViewById<ImageView>(R.id.fragment1Image)
            frame1Image?.apply {
                alpha = 1.0f - absPosition * 2
            }

            val frame1Spotlight = page.findViewById<ImageView>(R.id.fragment1spotlight)
            frame1Spotlight?.apply {
                scaleX = 1.0f - absPosition * 2
                scaleY = 1.0f - absPosition * 2
            }

            val frame2Title = page.findViewById<TextView>(R.id.fragment2Title)
            frame2Title?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 1.0f
            }

            val frame2Subcopy = page.findViewById<TextView>(R.id.fragment2Subcopy)
            frame2Subcopy?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 0.6f
            }

            val frame2Image = page.findViewById<ImageView>(R.id.fragment2Image)
            frame2Image?.apply {
                alpha = 1.0f - absPosition * 2
            }

            val frame3Title = page.findViewById<TextView>(R.id.fragment3Title)
            frame3Title?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 1.0f
            }

            val frame3Subcopy = page.findViewById<TextView>(R.id.fragment3Subcopy)
            frame3Subcopy?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 0.6f
            }

            val frame3Image = page.findViewById<ImageView>(R.id.fragment3Image)
            frame3Image?.apply {
                alpha = 1.0f - absPosition * 2
            }

            val frame4Title = page.findViewById<TextView>(R.id.fragment4Title)
            frame4Title?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 1.0f
            }

            val frame4Subcopy = page.findViewById<TextView>(R.id.fragment4Subcopy)
            frame4Subcopy?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 0.6f
            }

            val frame4Switch = page.findViewById<Switch>(R.id.fragment4Switch)
            frame4Switch?.apply {
                alpha = 1.0f - absPosition * 2
                translationX = pageWidthTimesPosition * 1.0f
            }

        }
    }
}