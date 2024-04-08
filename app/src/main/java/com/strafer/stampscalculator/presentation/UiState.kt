package com.strafer.stampscalculator.presentation

import android.view.View
import android.widget.Space
import android.widget.TextView

interface UiState {

    fun apply(
        resultTextView: TextView,
        spacing: Space
    )

    class ResultState(val result: String) : UiState {
        override fun apply(
            resultTextView: TextView,
            spacing: Space
        ) {
            resultTextView.visibility = View.VISIBLE
            spacing.visibility = View.GONE
        }
    }

    class ErrorState : UiState {
        override fun apply(
            resultTextView: TextView,
            spacing: Space
        ) {
            resultTextView.visibility = View.GONE
            spacing.visibility = View.VISIBLE
        }
    }

    class CleanState : UiState {
        override fun apply(
            resultTextView: TextView,
            spacing: Space
        ) {
            resultTextView.text = ""
            resultTextView.visibility = View.GONE
            spacing.visibility = View.VISIBLE
        }
    }
}