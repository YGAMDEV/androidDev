package com.timsimonhughes.ygam.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.timsimonhughes.ygam.adapters.OnboardingAdapter
import com.timsimonhughes.ygam.fragments.*
import com.timsimonhughes.ygam.pageTransformers.OnboardingPageTransformer
import com.rd.PageIndicatorView
import com.rd.animation.type.AnimationType
import com.timsimonhughes.ygam.R
import kotlinx.android.synthetic.main.activity_onboarding.*


class OnboardingActivity : AppCompatActivity() {

    private var mOnboardingAdapter: OnboardingAdapter?=null
    private lateinit var mViewPager: ViewPager
    private lateinit var mNextButton: ImageButton
    private lateinit var mFinishButton: Button
    private lateinit var mSkipButton: Button
    private var pagePosition: Int = 0
    private lateinit var mPageTransformer: OnboardingPageTransformer
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //checkFirstRun()

        setContentView(R.layout.activity_onboarding)
        setupViews()

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
                val x = ((viewPager.width * position + positionOffsetPixels) * computeFactor()).toInt()
                scrollView.scrollTo(x, 0)

            }
            override fun onPageSelected(position: Int) {
                pageIndicatorView.selection = position
                pagePosition = position

                mNextButton.visibility = if (position == 4) View.GONE else View.VISIBLE
                mFinishButton.visibility = if (position == 4) View.VISIBLE else View.GONE
            }
            override fun onPageScrollStateChanged(state: Int) {}

            private fun computeFactor(): Float {
                return (backgroundImage.width - viewPager.width) / (viewPager.width * (viewPager.adapter!!.count - 1)).toFloat()
            }

        })

        mNextButton.setOnClickListener {
            pagePosition += 1
            mViewPager.setCurrentItem(pagePosition, true)
        }

        mSkipButton.setOnClickListener {
            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)
        }
        mFinishButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun checkFirstRun() {
        sharedPreferences = getSharedPreferences("com.timsimonhughes.ygam", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("firstRun", true)) {
            sharedPreferences.edit().putBoolean("firstRun", false).apply()
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViews() {
        mOnboardingAdapter = OnboardingAdapter(supportFragmentManager)
        mOnboardingAdapter!!.addFragment(OnboardingFragment0(), "Fragment 0")
        mOnboardingAdapter!!.addFragment(OnboardingFragment1(), "Fragment 1")
        mOnboardingAdapter!!.addFragment(OnboardingFragment2(), "Fragment 2")
        mOnboardingAdapter!!.addFragment(OnboardingFragment3(), "Fragment 3")
        mOnboardingAdapter!!.addFragment(OnboardingFragment4(), "Fragment 4")

        mSkipButton = findViewById(R.id.intro_btn_skip)
        mNextButton = findViewById(R.id.intro_btn_next)
        mFinishButton = findViewById(R.id.intro_btn_finish)

    }

}



