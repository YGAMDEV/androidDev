package com.scrabit.ygam.model

import com.scrabit.ygam.R

class Questions {

    lateinit var questions: ArrayList<Question>

    fun Questions() {
        questions = ArrayList<Question>(10)

        questions[0] = Question(0, R.string.question0.toString(), Choice(R.string.question0_choice, 1), false)
        questions[1] = Question(1, R.string.question1.toString(), Choice(R.string.question1_choice, 2), false)
        questions[2] = Question(2, R.string.question2.toString(), Choice(R.string.question2_choice, 3), false)
        questions[3] = Question(3, R.string.question3.toString(), Choice(R.string.question3_choice, 4), false)
        questions[4] = Question(4, R.string.question4.toString(), Choice(R.string.question4_choice, 5), false)
        questions[5] = Question(5, R.string.question5.toString(), Choice(R.string.question5_choice, 6), false)
        questions[6] = Question(6, R.string.question6.toString(), Choice(R.string.question6_choice, 7), false)
        questions[7] = Question(7, R.string.question7.toString(), Choice(R.string.question7_choice, 8), false)
        questions[8] = Question(8, R.string.question8.toString(), Choice(R.string.question8_choice, 9), false)
        questions[9] = Question(9, R.string.question9.toString(), Choice(R.string.question9_choice, 0), true)

    }

    fun getQuestion(questionNumber: Int): Question {
        var questionNumber = questionNumber

        if (questionNumber >= questions.size) {
            questionNumber = 0
        }
        return questions[questionNumber]
    }

}