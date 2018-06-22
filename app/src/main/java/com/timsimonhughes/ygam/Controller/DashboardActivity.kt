package com.timsimonhughes.ygam.Controller

import android.os.Bundle
import android.support.design.widget.*
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.timsimonhughes.ygam.Adapters.DashboardPagerAdapter
import com.timsimonhughes.ygam.Fragments.DashboardBadgesFragment
import com.timsimonhughes.ygam.Fragments.DashboardTasksFragment
import com.timsimonhughes.ygam.Fragments.DashboardTrackerFragment
import com.timsimonhughes.ygam.R

import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager
    private var mDashboardAdapter: DashboardPagerAdapter? = null
    private lateinit var mTabLayout: TabLayout
    private lateinit var mCollapsingToolbarLayout: CollapsingToolbarLayout
    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        actionBar.setDisplayHomeAsUpEnabled(true)

        mCollapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout)
        mCollapsingToolbarLayout.isTitleEnabled = false

        mDrawerLayout = findViewById(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        if (navigationView != null) {
            setupDrawerContent(navigationView)
        }

        mTabLayout = findViewById(R.id.dashboardTabs)
        mViewPager = findViewById (R.id.dashboardViewpager)

        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 1"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 2"))
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 3"))
        mTabLayout.tabGravity = TabLayout.GRAVITY_FILL

        mDashboardAdapter = DashboardPagerAdapter(supportFragmentManager)
        mDashboardAdapter!!.addFragment(DashboardTrackerFragment())
        mDashboardAdapter!!.addFragment(DashboardTasksFragment())
        mDashboardAdapter!!.addFragment(DashboardBadgesFragment())

        mViewPager.adapter = mDashboardAdapter


        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        mViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mTabLayout))
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                mViewPager.currentItem = tab.position }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            mDrawerLayout.closeDrawers()
            true
        }
    }

}

