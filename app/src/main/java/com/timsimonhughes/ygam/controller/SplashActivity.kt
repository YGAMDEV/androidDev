package com.timsimonhughes.ygam.controller

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.timsimonhughes.ygam.R

class SplashActivity : AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val mSplashDelay: Long = 3000

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, OnboardingActivity::class.java)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, mSplashDelay)
    }

    override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

}