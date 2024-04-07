package com.strafer.stampscalculator

import android.app.Application
import android.view.View
import android.widget.Space
import android.widget.TextView
import androidx.core.content.ContextCompat.getString
import com.google.android.material.textfield.TextInputLayout

interface UiState {

    fun apply(
        weightInputLayout: TextInputLayout,
        resultTextView: TextView,
        spacing: Space
    )

    class Success(private val result: String) : UiState {
        override fun apply(
            weightInputLayout: TextInputLayout,
            resultTextView: TextView,
            spacing: Space
        ) {
            weightInputLayout.error = ""
            resultTextView.visibility = View.VISIBLE
            spacing.visibility = View.GONE

            // probably memory leak with passing the context
            // doesn't work with getString, and no context

            // TODO решить вопрос с получением ресурсов внутри UiState
            resultTextView.text =
                "Стоимость марок на конверте должна составлять\n\n$result руб."

        }
    }

    class Error : UiState {
        override fun apply(
            weightInputLayout: TextInputLayout,
            resultTextView: TextView,
            spacing: Space
        ) {
            weightInputLayout.error = "Пустое поле ввода!"
            resultTextView.visibility = View.GONE
            spacing.visibility = View.VISIBLE
        }

    }
}