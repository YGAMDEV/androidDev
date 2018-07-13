package com.timsimonhughes.ygam.adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

class DashboardPagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    private var mFragmentItems:ArrayList<Fragment> = ArrayList()

    fun addFragment(fragmentItem:Fragment) {
        mFragmentItems.add(fragmentItem)
    }

    override fun getItem(position: Int): Fragment? {
        return mFragmentItems[position]
    }

    override fun getCount(): Int {
        return mFragmentItems.size
    }

}