package com.strafer.stampscalculator

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Space
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputLayout = findViewById<TextInputLayout>(R.id.weightInputLayout)
        val weightInputEditText = findViewById<TextInputEditText>(R.id.weightInputEditText)

        val spacing = findViewById<Space>(R.id.spacing)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            hideKeyboard(weightInputEditText)
            if (weightInputEditText.text?.isNotEmpty() == true) {
                textInputLayout.error = ""
                Calculator.calculateWeight(weightInputEditText.text.toString().toDouble())
                spacing.visibility = View.GONE

                // TODO можно записать все 3 вариации слова рубль в ресурсы
                resultTextView.text = "Стоимость марок на конверте должна составлять\n\n${Calculator.weight} ${Calculator.getLiteral()}"
                resultTextView.visibility = View.VISIBLE

            } else {
                textInputLayout.error = getString(R.string.empty_field)
                resultTextView.visibility = View.GONE
                spacing.visibility = View.VISIBLE
            }

        }

    }
}

fun AppCompatActivity.hideKeyboard(view: View){
    val imm = this.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}