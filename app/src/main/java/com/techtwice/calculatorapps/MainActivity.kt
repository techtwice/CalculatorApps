package com.techtwice.calculatorapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt0.setOnClickListener(this)
        bt1.setOnClickListener(this)
        bt2.setOnClickListener(this)
        bt3.setOnClickListener(this)
        bt4.setOnClickListener(this)
        bt5.setOnClickListener(this)
        bt6.setOnClickListener(this)
        bt7.setOnClickListener(this)
        bt8.setOnClickListener(this)
        bt9.setOnClickListener(this)
        btDot.setOnClickListener(this)
        btPlusMins.setOnClickListener(this)
        btMul.setOnClickListener(this)
        btDiv.setOnClickListener(this)
        btSub.setOnClickListener(this)
        btSum.setOnClickListener(this)
        btPercent.setOnClickListener(this)
        btEqual.setOnClickListener(this)
        btClean.setOnClickListener(this)



    }

    override fun onClick(view: View) {

        val btSelect = view as Button
        var btClickValue: String = etShowNumber.text.toString()

        when (btSelect.id) {
            bt0.id -> {
                btClickValue += "0"
            }
            bt1.id -> {
                btClickValue += "1"
            }
            bt2.id -> {
                btClickValue += "2"
            }
            bt3.id -> {
                btClickValue += "3"
            }
            bt4.id -> {
                btClickValue += "4"
            }
            bt5.id -> {
                btClickValue += "5"
            }
            bt6.id -> {
                btClickValue += "6"
            }
            bt7.id -> {
                btClickValue += "7"
            }
            bt8.id -> {
                btClickValue += "8"
            }
            bt9.id -> {
                btClickValue += "9"
            }
            btDot.id -> {
                //TODO: prevent adding more than 1 dot
                btClickValue += "."
            }
            btPlusMins.id -> {
                btClickValue = "-$btClickValue"
            }
            btMul.id -> {
                op = "*"
            }
            btDiv.id -> {
                op = "/"
            }
            btSub.id -> {
                op = "-"
            }
            btSum.id -> {
                op = "+"
            }
            btPercent.id -> {

            }
            btEqual.id -> {

            }
            btClean.id -> {

            }

        }

        etShowNumber.setText(btClickValue)

    }
}
