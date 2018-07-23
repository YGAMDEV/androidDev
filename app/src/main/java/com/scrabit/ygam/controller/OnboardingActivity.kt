package com.scrabit.ygam.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.View
import com.scrabit.ygam.adapters.OnboardingAdapter
import com.scrabit.ygam.fragments.*
import com.scrabit.ygam.pageTransformers.OnboardingPageTransformer
import com.rd.animation.type.AnimationType
import com.scrabit.ygam.R
import kotlinx.android.synthetic.main.activity_onboarding.*
import android.view.WindowManager




class OnboardingActivity : AppCompatActivity() {

    private var mOnboardingAdapter: OnboardingAdapter?=null
    private var pagePosition: Int = 0
    private lateinit var mPageTransformer: OnboardingPageTransformer
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //checkFirstRun()

        setContentView(R.layout.activity_onboarding)

        setupViews()

        pageIndicatorView.setAnimationType(AnimationType.WORM)
        pageIndicatorView.count = 5
        pageIndicatorView.selection = 0

        viewPager.adapter = mOnboardingAdapter

        mPageTransformer = OnboardingPageTransformer()
        viewPager.setPageTransformer(false,  mPageTransformer)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val x = ((viewPager.width * position + positionOffsetPixels) * computeFactor()).toInt()
                scrollView.scrollTo(x, 0)
            }

            override fun onPageSelected(position: Int) {
                pageIndicatorView.selection = position
                pagePosition = position

                intro_btn_next.visibility = if (position == 4) View.GONE else View.VISIBLE
                intro_btn_finish.visibility = if (position == 4) View.VISIBLE else View.GONE
            }

            override fun onPageScrollStateChanged(state: Int) {}

            private fun computeFactor(): Float {
                return (backgroundImage.width - viewPager.width) / (viewPager.width * (viewPager.adapter!!.count - 1)).toFloat()
            }

        })

        intro_btn_next.setOnClickListener {
            pagePosition += 1
            viewPager.setCurrentItem(pagePosition, true)
        }

        intro_btn_skip.setOnClickListener {
            val intent = Intent(this, QuestionsActivity::class.java)
            startActivity(intent)
        }
        intro_btn_finish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

    }

    private fun checkFirstRun() {
        sharedPreferences = getSharedPreferences("com.ygam.scrabit", Context.MODE_PRIVATE)

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

    }

}



