package com.scrabit.ygam.controller

import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.PickerItem
import com.scrabit.ygam.R
import com.scrabit.ygam.model.Question
import com.scrabit.ygam.model.Questions
import kotlinx.android.synthetic.main.activity_questions.*
import java.util.*


class QuestionsActivity : AppCompatActivity() {

    var bubblesSelected: Int = 0
    private val pageStack = Stack<Int>()
    private var questions: Questions? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionLabel.text = getString(R.string.question1)
        val answerList = arrayOf(
                "Games Apps",
                "Messaging",
                "Socialising",
                "To win money",
                "Boredom",
                "For the challenge",
                "Other")
        initBubblePicker(answerList)

//        loadQuestion(0)

    }

    private fun loadQuestion(questionNumber: Int) {
        pageStack.push(questionNumber)

        val question = Questions().getQuestion(questionNumber)
        val pageText = getString(question.textId)
        questionLabel.text = pageText

        if (question.isFinalPage) {
            confirmationButton.setOnClickListener {
                loadQuestion(0)
            }
        } else {
            loadButton(question)
        }
    }

    private fun loadButton(question: Question) {
       confirmationButton.setOnClickListener {
           val nextPage = question.choice.nextQuestion
           loadQuestion(nextPage)
       }
    }

    private fun initBubblePicker(answerList: Array<String>) {

        bubblePicker.adapter = object : BubblePickerAdapter {
            override val totalCount = answerList.size

            override fun getItem(position: Int): PickerItem {
                return PickerItem().apply {
                    title = answerList[position]
                    color = ContextCompat.getColor(this@QuestionsActivity, R.color.white90)
                    textColor = ContextCompat.getColor(this@QuestionsActivity, android.R.color.white)


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        typeface = resources.getFont(R.font.rubik_medium)
                    }
                }
            }
        }
        bubblePicker.bubbleSize = 20
        bubblePicker.centerImmediately
        bubblePicker.listener = object : BubblePickerListener {
            override fun onBubbleSelected(item: PickerItem) {
                bubblesSelected += 1


                if (bubblesSelected >= 0) {
                    confirmationButton.isEnabled = true
                    confirmationButton.alpha = 1.0.toFloat()
                }

                val selection = item.title
                Toast.makeText(this@QuestionsActivity, selection, Toast.LENGTH_LONG).show()
            }

            override fun onBubbleDeselected(item: PickerItem) {
                bubblesSelected -= 1

                if (bubblesSelected == 0) {
                    confirmationButton.isEnabled = false
                    confirmationButton.alpha = 0.2.toFloat()
                }

            }
        }
    }

    override fun onResume() {
        super.onResume()
        bubblePicker.onResume()
    }

    override fun onPause() {
        super.onPause()
        bubblePicker.onPause()
    }

    private fun toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


}
