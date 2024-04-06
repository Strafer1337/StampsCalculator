package com.strafer.stampscalculator

import android.app.Application
import android.view.View
import android.widget.Space
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.strafer.stampscalculator.utilities.Calculator
import com.strafer.stampscalculator.utilities.Literal

interface UiState {

    fun apply(
        weightInputLayout: TextInputLayout,
        resultTextView: TextView,
        spacing: Space
    )

    object Success : UiState {
        override fun apply(
            weightInputLayout: TextInputLayout,
            resultTextView: TextView,
            spacing: Space
        ) {
            weightInputLayout.error = ""

            val weight = weightInputLayout.editText!!.text.toString()
            val result = Calculator.calculateWeight(weight.toDouble())
            val literal = Literal.getLiteral(result)

            resultTextView.visibility = View.VISIBLE
            spacing.visibility = View.GONE

            resultTextView.text =
                Application().getString(R.string.result_starting_text, result, literal)

        }
    }

    object Error : UiState {
        override fun apply(
            weightInputLayout: TextInputLayout,
            resultTextView: TextView,
            spacing: Space
        ) {
            weightInputLayout.error = Application().getString(R.string.empty_field)
            resultTextView.visibility = View.GONE
            spacing.visibility = View.VISIBLE
        }

    }
}