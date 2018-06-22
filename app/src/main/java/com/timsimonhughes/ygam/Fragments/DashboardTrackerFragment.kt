package com.timsimonhughes.ygam.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.timsimonhughes.ygam.Adapters.MockDashboardModelAdapter

import com.timsimonhughes.ygam.R


/**
 * A simple [Fragment] subclass.
 *
 */
class DashboardTrackerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard_tracker, container, false)

        val frameLayout = view.findViewById<FrameLayout>(R.id.dummyfrag_bg)
        val recyclerView = view.findViewById<RecyclerView>(R.id.dummyfrag_scrollableview)

        val linearLayoutManager = LinearLayoutManager(activity!!.baseContext)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)

        val adapter = MockDashboardModelAdapter(context)
        recyclerView.adapter = adapter

        return view
    }

}
