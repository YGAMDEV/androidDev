package com.scrabit.ygam.model



class Achievements (val achievementTitle: String?) {

    companion object {

        fun prepareAchievements(achievementTitles: Array<String>): ArrayList<Achievements> {
           val achievementsModel = ArrayList<Achievements>(achievementTitles.size)

            for (i in achievementTitles.indices) {
                val achievements = Achievements(achievementTitles[i])
                achievementsModel.add(achievements)
            }
            return achievementsModel
        }
    }
}

