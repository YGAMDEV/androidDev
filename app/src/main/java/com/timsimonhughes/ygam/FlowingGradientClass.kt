package com.timsimonhughes.ygam

import android.graphics.drawable.AnimationDrawable
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout

class FlowingGradientClass {

    private var duration = 4000
    private var relativeLayout: RelativeLayout? = null
    private var linearLayout: LinearLayout? = null
    private var imageView: ImageView? = null
    private var alphaInt: Int = 0
    private var drawableInt: Int = 0
    private lateinit var frameAnimation: AnimationDrawable

    fun start(): FlowingGradientClass {

        if (linearLayout != null) {
            linearLayout!!.setBackgroundResource(drawableInt)
        } else if (relativeLayout != null) {
            relativeLayout!!.setBackgroundResource(drawableInt)
        } else if (imageView != null) {
            imageView!!.setBackgroundResource(drawableInt)
        }
        if (linearLayout != null) {
            frameAnimation = linearLayout!!.background as AnimationDrawable
        } else if (relativeLayout != null) {
            frameAnimation = relativeLayout!!.background as AnimationDrawable
        } else if (imageView != null) {
            frameAnimation = imageView!!.background as AnimationDrawable
        }
        frameAnimation.setEnterFadeDuration(duration)
        frameAnimation.setExitFadeDuration(duration)
        frameAnimation.start()

        return this
    }

    fun setTransitionDuration(time: Int): FlowingGradientClass {
        this.duration = time
        return this
    }

    fun onLinearLayout(ll: LinearLayout): FlowingGradientClass {
        this.linearLayout = ll
        return this
    }

    fun onImageView(im: ImageView): FlowingGradientClass {
        this.imageView = im
        return this
    }

    fun onRelativeLayout(rl: RelativeLayout): FlowingGradientClass {
        this.relativeLayout = rl
        return this
    }

    fun setBackgroundResource(d: Int): FlowingGradientClass {
        this.drawableInt = d
        return this
    }

    fun setAlpha(alphaint: Int): FlowingGradientClass {
        this.alphaInt = alphaint
        frameAnimation.alpha = alphaint
        return this
    }

}