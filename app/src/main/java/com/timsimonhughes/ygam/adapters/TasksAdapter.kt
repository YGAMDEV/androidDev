package com.timsimonhughes.ygam.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.timsimonhughes.ygam.R
import com.timsimonhughes.ygam.model.MockDashboardModel
import java.util.ArrayList

class TasksAdapter(private val context: Context?) : RecyclerView.Adapter<TasksAdapter.TasksVh>() {

    private var mMockDashboardModels = ArrayList<MockDashboardModel>()

    init {

        mMockDashboardModels = MockDashboardModel.prepareDesserts(
                context!!.resources.getStringArray(R.array.dessert_names),
                context!!.resources.getStringArray(R.array.dessert_descriptions)) as ArrayList<MockDashboardModel>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksVh {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.mock_list_item, parent, false)
        return TasksAdapter.TasksVh(view)
    }

    override fun onBindViewHolder(holder: TasksVh, position: Int) {
        val mockDashboardModel = mMockDashboardModels[position]

        holder.mName.text = mockDashboardModel.name
        holder.mDescription.text = mockDashboardModel.description
        holder.mFirstLetter.text = mockDashboardModel.firstLetter.toString()

    }

    override fun getItemCount(): Int {
        return mMockDashboardModels.size
    }

    class TasksVh(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mName: TextView
        val mDescription: TextView
        val mFirstLetter: TextView

        init {

            mName = itemView.findViewById<View>(R.id.txt_name) as TextView
            mDescription = itemView.findViewById<View>(R.id.txt_desc) as TextView
            mFirstLetter = itemView.findViewById<View>(R.id.txt_firstletter) as TextView
        }
    }
}