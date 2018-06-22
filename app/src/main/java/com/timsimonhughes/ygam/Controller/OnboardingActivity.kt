package com.timsimonhughes.ygam.Controller

import android.animation.ArgbEvaluator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.timsimonhughes.ygam.Adapters.OnboardingAdapter
import com.timsimonhughes.ygam.Fragments.*
import com.timsimonhughes.ygam.PageTransformers.OnboardingPageTransformer
import com.rd.PageIndicatorView
import com.rd.animation.type.AnimationType
import com.timsimonhughes.ygam.R


class OnboardingActivity : AppCompatActivity() {

    private var mOnboardingAdapter: OnboardingAdapter?=null
    private lateinit var mViewPager: ViewPager
    private lateinit var mNextBtn: ImageButton
    private lateinit var mFinishBtn: Button
    private lateinit var mSkipBtn: Button
    private var pagePosition: Int = 0
    private lateinit var mPageTransformer: OnboardingPageTransformer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        mOnboardingAdapter = OnboardingAdapter(supportFragmentManager)
        mOnboardingAdapter!!.addFragment(OnboardingFragment1(), "Fragment 1")
        mOnboardingAdapter!!.addFragment(OnboardingFragment2(), "Fragment 2")
        mOnboardingAdapter!!.addFragment(OnboardingFragment3(), "Fragment 3")
        mOnboardingAdapter!!.addFragment(OnboardingFragment4(), "Fragment 4")
        mOnboardingAdapter!!.addFragment(OnboardingFragment5(), "Fragment 5")


        mSkipBtn = findViewById(R.id.intro_btn_skip)
        mNextBtn = findViewById(R.id.intro_btn_next)
        mFinishBtn = findViewById(R.id.intro_btn_finish)

        val color1 = ContextCompat.getColor(applicationContext, R.color.onboardingColor1)
        val color2 = ContextCompat.getColor(applicationContext, R.color.onboardingColor2)
        val color3 = ContextCompat.getColor(applicationContext, R.color.onboardingColor3)
        val color4 = ContextCompat.getColor(applicationContext, R.color.onboardingColor4)
        val color5 = ContextCompat.getColor(applicationContext, R.color.onboardingColor5)

        val colorList = intArrayOf(color1, color2, color3, color4, color5)

        val pageIndicatorView = findViewById<PageIndicatorView>(R.id.pageIndicatorView)
        pageIndicatorView.setAnimationType(AnimationType.WORM)
        pageIndicatorView.count = 5 // specify total count of indicators
        pageIndicatorView.selection = 0

        mViewPager = findViewById(R.id.viewPager)
        mViewPager.adapter = mOnboardingAdapter

        mPageTransformer = OnboardingPageTransformer()
        mViewPager.setPageTransformer(false,  mPageTransformer)
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                val evaluator = ArgbEvaluator()
                val colorUpdate = evaluator.evaluate(
                        positionOffset,
                        colorList[position],
                        colorList[if (position == 4) position else position + 1]
                ) as Int
                mViewPager.setBackgroundColor(colorUpdate)
            }

            override fun onPageSelected(position: Int) {

                pageIndicatorView.selection = position
                pagePosition = position

                mNextBtn.visibility = if (position == 4) View.GONE else View.VISIBLE
                mFinishBtn.visibility = if (position == 4) View.VISIBLE else View.GONE
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        mNextBtn.setOnClickListener {
            pagePosition += 1
            mViewPager.setCurrentItem(pagePosition, true)
        }

        mSkipBtn.setOnClickListener { finish() }
        mFinishBtn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

    }

}



