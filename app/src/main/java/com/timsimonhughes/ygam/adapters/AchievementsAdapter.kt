package com.timsimonhughes.ygam.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.timsimonhughes.ygam.R
import com.timsimonhughes.ygam.model.Achievements
import java.util.ArrayList

class AchievementsAdapter (private var context: Context?): RecyclerView.Adapter<AchievementsAdapter.ViewHolder>() {

    private var achievementsModel = ArrayList<Achievements>()

    init {
        achievementsModel = Achievements.prepareAchievements(
                context!!.resources.getStringArray(R.array.achievements))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.achievement_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val achievementsModel = achievementsModel[position]

        holder.achievementTitle.text = achievementsModel.achievementTitle
    }

    override fun getItemCount(): Int {
        return achievementsModel.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val achievementTitle: TextView

        init {
            achievementTitle = itemView.findViewById(R.id.textViewAchievementTitle)
        }

    }

}
