package com.example.babyplay

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButton()
        btnleft.setOnClickListener{
            checkanswer(true)
            assignNumbersToButton()
        }

        btnright.setOnClickListener {
            checkanswer(false)
            assignNumbersToButton()
        }
    }
    private fun checkanswer(isLeftButtonSelected:Boolean){
        val leftnum:Int =btnleft.text.toString().toInt()
        val rightnum:Int =btnright.text.toString().toInt()
        val isAnswerCorrect=if (isLeftButtonSelected) leftnum>rightnum else rightnum>leftnum
        if (isAnswerCorrect){
            backgroungview.setBackgroundColor(Color.GREEN)
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
        }
        else{
            backgroungview.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButton() {
        val r= Random()
        val  leftnum:Int=r.nextInt(10)
        var rightnum:Int=leftnum
        while (rightnum==leftnum) {
            rightnum=r.nextInt(10)
        }
        btnleft.text= leftnum.toString()
        btnright.text=rightnum.toString()

    }
}