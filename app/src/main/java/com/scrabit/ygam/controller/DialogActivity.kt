package com.scrabit.ygam.controller

import android.app.Activity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.transition.ArcMotion
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import com.scrabit.ygam.ui.MorphFabToDialog
import com.scrabit.ygam.ui.MorphTransition
import com.scrabit.ygam.R

class DialogActivity : AppCompatActivity() {

    private var container: ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        container = findViewById(R.id.container)

        setupSharedElementTransitions1()
        //setupSharedElementTransitions2()

        val dismissListener = View.OnClickListener { dismiss() }
        container!!.setOnClickListener(dismissListener)
        container!!.findViewById<Button>(R.id.close).setOnClickListener(dismissListener)
    }


    fun setupSharedElementTransitions1() {
        val arcMotion = ArcMotion()
        arcMotion.minimumHorizontalAngle = 50f
        arcMotion.minimumVerticalAngle = 50f

        val easeInOut = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in)

        val sharedEnter = MorphFabToDialog()
        sharedEnter.pathMotion = arcMotion
        sharedEnter.interpolator = easeInOut

        val sharedReturn = MorphFabToDialog()
        sharedReturn.pathMotion = arcMotion
        sharedReturn.interpolator = easeInOut

        if (container != null) {
            sharedEnter.addTarget(container)
            sharedReturn.addTarget(container)
        }
        window.sharedElementEnterTransition = sharedEnter
        window.sharedElementReturnTransition = sharedReturn
    }

    fun setupSharedElementTransitions2() {
        val arcMotion = ArcMotion()
        arcMotion.minimumHorizontalAngle = 50f
        arcMotion.minimumVerticalAngle = 50f

        val easeInOut = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in)

        val sharedEnter = MorphTransition(
                ContextCompat.getColor(this, R.color.fab_background_color),
                ContextCompat.getColor(this, R.color.dialog_background_color),
                resources.getDimensionPixelSize(R.dimen.dialog_corners),
                100,
                false
        )

        sharedEnter.pathMotion = arcMotion
        sharedEnter.interpolator = easeInOut


        val sharedReturn = MorphTransition(
                ContextCompat.getColor(this, R.color.dialog_background_color),
                ContextCompat.getColor(this, R.color.fab_background_color),
                resources.getDimensionPixelSize(R.dimen.dialog_corners),
                100,
                false)
        sharedReturn.pathMotion = arcMotion
        sharedReturn.interpolator = easeInOut

        if (container != null) {
            sharedEnter.addTarget(container)
            sharedReturn.addTarget(container)
        }
        window.sharedElementEnterTransition = sharedEnter
        window.sharedElementReturnTransition = sharedReturn
    }

    override fun onBackPressed() {
        dismiss()
    }

    fun dismiss() {
        setResult(Activity.RESULT_CANCELED)
        finishAfterTransition()
    }

}
