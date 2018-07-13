package com.scrabit.ygam

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.View

class FlowingGradientView : View {

    internal var duration: Int = 0
    private var draw: Int = 0

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.gradient, 0, 0)

        draw = typedArray.getResourceId(R.styleable.gradient_transition_drawable, R.drawable.gradient_translate)
        duration = typedArray.getInt(R.styleable.gradient_transition_duration, 75)
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    private fun init() {
        setBackgroundResource(draw)
        val frameAnimation = background as AnimationDrawable
        frameAnimation.setEnterFadeDuration(duration)
        frameAnimation.setExitFadeDuration(duration)
        post { frameAnimation.start() }
    }
}