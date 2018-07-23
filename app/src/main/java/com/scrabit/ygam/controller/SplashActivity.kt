package com.scrabit.ygam.controller

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.scrabit.ygam.R

class SplashActivity : AppCompatActivity() {

    private var delayHandler: Handler? = null
    private val splashDelay: Long = 3000

    private val splashRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, OnboardingActivity::class.java)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delayHandler = Handler()
        delayHandler!!.postDelayed(splashRunnable, splashDelay)
    }

    override fun onDestroy() {

        if (delayHandler != null) {
            delayHandler!!.removeCallbacks(splashRunnable)
        }
        super.onDestroy()
    }

}