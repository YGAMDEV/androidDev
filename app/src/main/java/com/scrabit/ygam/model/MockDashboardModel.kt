package com.scrabit.ygam.model

import java.util.ArrayList

class MockDashboardModel(var name: String?, var description: String?) {
    var firstLetter: String? = null

    init {
        this.firstLetter = name!!.get(0).toString()
    }

    companion object {

        fun prepareDesserts(names: Array<String>, descriptions: Array<String>): List<MockDashboardModel> {
            val mockDashboardModels = ArrayList<MockDashboardModel>(names.size)

            for (i in names.indices) {
                val mockDashboardModel = MockDashboardModel(names[i], descriptions[i])
                mockDashboardModels.add(mockDashboardModel)
            }

            return mockDashboardModels
        }
    }
}
