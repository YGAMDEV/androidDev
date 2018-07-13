package com.scrabit.ygam.model

import com.scrabit.ygam.R

class Questions {

    lateinit var questions: ArrayList<Question>

    fun Questions() {
        questions = ArrayList<Question>(9)

        questions[0] = Question(R.string.question_0)
        questions[1] = Question(R.string.question_1)
        questions[2] = Question(R.string.question_2)
        questions[3] = Question(R.string.question_3)
        questions[4] = Question(R.string.question_4)
        questions[5] = Question(R.string.question_5)
        questions[6] = Question(R.string.question_6)
        questions[7] = Question(R.string.question_7)
        questions[8] = Question(R.string.question_8)
        questions[9] = Question(R.string.question_9)

    }

    fun getQuestion(questionNumber: Int): Question {
        var questionNumber = questionNumber
        if (questionNumber >= questions.size) {
            questionNumber = 0
        }
        return questions[questionNumber]
    }


}