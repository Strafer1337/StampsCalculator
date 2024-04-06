package com.strafer.stampscalculator.activities

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.strafer.stampscalculator.R
import com.strafer.stampscalculator.utilities.Calculator
import com.strafer.stampscalculator.utilities.Literal
import com.strafer.stampscalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            hideKeyboard(binding.weightInputEditText)

            val weight = binding.weightInputEditText.text.toString()

            if (weight.trim().isEmpty()) {
                binding.weightInputLayout.error = getString(R.string.empty_field)
                binding.resultTextView.visibility = View.GONE
                binding.spacing.visibility = View.VISIBLE
            } else {
                binding.weightInputLayout.error = ""
                val result = Calculator.calculateWeight(weight.toDouble())
                val literal = Literal.getLiteral(result)

                binding.resultTextView.visibility = View.VISIBLE
                binding.spacing.visibility = View.GONE

                binding.resultTextView.text =
                    getString(R.string.result_starting_text, result, literal)

            }
        }
    }
}

fun AppCompatActivity.hideKeyboard(view: View) {
    val imm = this.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}