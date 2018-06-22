package com.timsimonhughes.ygam.Adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by thu01 on 21/06/2018.
 */

class DashboardPagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    private var mFragmentItems:ArrayList<Fragment> = ArrayList()
    //private var mFragmentTitles:ArrayList<String> = ArrayList()

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