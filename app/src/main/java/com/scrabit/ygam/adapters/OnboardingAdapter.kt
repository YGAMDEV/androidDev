package com.scrabit.ygam.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class OnboardingAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    private var mFragmentItems:ArrayList<Fragment> = ArrayList()
    private var mFragmentTitles:ArrayList<String> = ArrayList()

    fun addFragment(fragmentItem:Fragment, fragmentTitle:String) {
        mFragmentItems.add(fragmentItem)
        mFragmentTitles.add(fragmentTitle)
    }

    override fun getItem(position: Int): Fragment? {
        return mFragmentItems[position]
    }

    override fun getCount(): Int {
        return mFragmentItems.size
    }

}