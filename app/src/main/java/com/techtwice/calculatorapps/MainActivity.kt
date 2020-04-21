package com.techtwice.calculatorapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast as Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btClickValue = ""
    private var op = ""
    private var oldNumber = ""
    private var newNumber = ""
    private var isNewOp = true

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

        if (isNewOp) {
            etShowNumber.setText("")
        }
        isNewOp = false

        val btSelect = view as Button
        btClickValue = etShowNumber.text.toString()

        when (btSelect.id) {
            bt0.id -> {
                btClickValue += "0"
                displayClickValue()
            }
            bt1.id -> {
                btClickValue += "1"
                displayClickValue()
            }
            bt2.id -> {
                btClickValue += "2"
                displayClickValue()
            }
            bt3.id -> {
                btClickValue += "3"
                displayClickValue()
            }
            bt4.id -> {
                btClickValue += "4"
                displayClickValue()
            }
            bt5.id -> {
                btClickValue += "5"
                displayClickValue()
            }
            bt6.id -> {
                btClickValue += "6"
                displayClickValue()
            }
            bt7.id -> {
                btClickValue += "7"
                displayClickValue()
            }
            bt8.id -> {
                btClickValue += "8"
                displayClickValue()
            }
            bt9.id -> {
                btClickValue += "9"
                displayClickValue()
            }
            btDot.id -> {
                //TODO: prevent adding more than 1 dot
                btClickValue += "."
                displayClickValue()
            }
            btPlusMins.id -> {
                btClickValue = "-$btClickValue"
                displayClickValue()
            }
            btMul.id -> {
                op = "*"
                operationEvent()
                btClickValue += "*"
                displayClickValue()
                return
            }
            btDiv.id -> {
                op = "/"
                operationEvent()
                btClickValue += "/"
                displayClickValue()
                return
            }
            btSub.id -> {
                op = "-"
                operationEvent()
                btClickValue += "-"
                displayClickValue()
                return
            }
            btSum.id -> {
                op = "+"
                operationEvent()
                btClickValue += "+"
                displayClickValue()
                return
            }
            btPercent.id -> {
                val percentNumber: Double = etShowNumber.text.toString().toDouble() / 100
                etShowNumber.setText(percentNumber.toString())
                isNewOp = true
                return
            }
            btEqual.id -> {
                equalEvent()
                return
            }
            R.id.btClean -> {
                cleanShowNumber()
                return
            }
        }

    }

    private fun displayClickValue() {
        etShowNumber.setText(btClickValue)
    }

    private fun operationEvent() {
        oldNumber = etShowNumber.text.toString()
        //   isNewOp = true
        Toast.makeText(this, "oldNumber: $oldNumber", Toast.LENGTH_SHORT).show()
    }

    private fun equalEvent() {
        newNumber = etShowNumber.text.toString()
        var finalNumber: Double? = null

        when (op) {

            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
        }

        etShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    private fun cleanShowNumber() {
        // Toast.makeText(this, "cleanShowNumber", Toast.LENGTH_SHORT).show()
        etShowNumber.setText("0")
        isNewOp = true
    }

}
