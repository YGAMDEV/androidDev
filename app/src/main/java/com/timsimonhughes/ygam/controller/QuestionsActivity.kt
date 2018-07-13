package com.timsimonhughes.ygam.controller

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.BubbleGradient
import com.igalata.bubblepicker.model.PickerItem
import com.timsimonhughes.ygam.R
import kotlinx.android.synthetic.main.activity_questions.*


class QuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        question_label.text = "Did you use any of these devices yesterday?"
        val titles = resources.getStringArray(R.array.answers)
        val colors = resources.obtainTypedArray(R.array.colors)
        //val images = resources.obtainTypedArray(R.array.images)

        picker.adapter = object : BubblePickerAdapter {

            override val totalCount = titles.size

            override fun getItem(position: Int): PickerItem {
                return PickerItem().apply {
                    title = titles[position]
                    gradient = BubbleGradient(colors.getColor((position * 2) % 8, 0),
                            colors.getColor((position * 2) % 8 + 1, 0), BubbleGradient.VERTICAL)
                    textColor = ContextCompat.getColor(this@QuestionsActivity, android.R.color.white)
                    //backgroundImage = ContextCompat.getDrawable(this@QuestionsActivity, images.getResourceId(position, 0))
                }
            }
        }

        colors.recycle()
        //images.recycle()

        picker.bubbleSize = 30
        picker.listener = object : BubblePickerListener {
            override fun onBubbleSelected(item: PickerItem) = toast("${item.title} selected")

            override fun onBubbleDeselected(item: PickerItem) = toast("${item.title} deselected")
        }
    }

    override fun onResume() {
        super.onResume()
        picker.onResume()
    }

    override fun onPause() {
        super.onPause()
        picker.onPause()
    }

    private fun toast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


}
