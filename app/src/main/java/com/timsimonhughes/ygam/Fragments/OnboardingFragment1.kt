package com.timsimonhughes.ygam.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.timsimonhughes.ygam.R

/**
 * A simple [Fragment] subclass.
 */
class OnboardingFragment1 : Fragment() {

    lateinit var circleCenter: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.onboarding_fragment1, container, false)
        return view
    }
}
