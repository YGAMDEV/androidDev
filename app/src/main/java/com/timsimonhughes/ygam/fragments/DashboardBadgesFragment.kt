package com.timsimonhughes.ygam.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.timsimonhughes.ygam.R
import com.timsimonhughes.ygam.adapters.AchievementsAdapter


class DashboardBadgesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard_badges, container, false)

        val frameLayout = view.findViewById<FrameLayout>(R.id.dummyfrag_bg)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewBadges)

        val numberOfColumns = 3
        recyclerView.layoutManager = GridLayoutManager(context, numberOfColumns)

        val adapter = AchievementsAdapter(context)
        recyclerView.adapter = adapter

        return view
    }
}
