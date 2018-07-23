package com.scrabit.ygam.controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.*
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.scrabit.ygam.adapters.DashboardPagerAdapter
import com.scrabit.ygam.fragments.DashboardBadgesFragment
import com.scrabit.ygam.fragments.DashboardTasksFragment
import com.scrabit.ygam.fragments.DashboardTrackerFragment
import com.scrabit.ygam.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dashboardPagerAdapter: DashboardPagerAdapter? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        actionBar.setDisplayHomeAsUpEnabled(true)

        collapsingToolbarLayout.isTitleEnabled = false

        initViewPager()
        initTabs()
        initDashboardAdapter()
        initNavigationView()

        /*floatingActionButton.setOnClickListener { view ->
            when (view.id) {
                R.id.floatingActionButton -> {

                    val intent = Intent(this@MainActivity, DialogExampleActivity::class.java)
                    val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, floatingActionButton, getString(R.string.transition_dialog))
                    startActivityForResult(intent, RC_LOGIN, options.toBundle())

                }
            }
        }*/
    }

    private fun initViewPager() {
        dashboardViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayoutDashboardTabs))
    }

    private fun initTabs() {
        tablayoutDashboardTabs.addTab(tablayoutDashboardTabs.newTab().setText(getString(R.string.tab_1_label)))
        tablayoutDashboardTabs.addTab(tablayoutDashboardTabs.newTab().setText(getString(R.string.tab_2_label)))
        tablayoutDashboardTabs.addTab(tablayoutDashboardTabs.newTab().setText(getString(R.string.tab_3_label)))
        tablayoutDashboardTabs.tabGravity = TabLayout.GRAVITY_FILL
        tablayoutDashboardTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) { dashboardViewpager.currentItem = tab.position }
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun initDashboardAdapter() {
        dashboardPagerAdapter = DashboardPagerAdapter(supportFragmentManager)
        dashboardPagerAdapter!!.addFragment(DashboardTrackerFragment())
        dashboardPagerAdapter!!.addFragment(DashboardTasksFragment())
        dashboardPagerAdapter!!.addFragment(DashboardBadgesFragment())
        dashboardViewpager.adapter = dashboardPagerAdapter
    }

    private fun initNavigationView() {
        if (navView != null) {
            setupDrawerContent(navView)
        }
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

