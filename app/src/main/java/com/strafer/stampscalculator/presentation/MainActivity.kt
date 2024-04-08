package com.strafer.stampscalculator.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.strafer.stampscalculator.R
import com.strafer.stampscalculator.databinding.ActivityMainBinding
import com.strafer.stampscalculator.utilities.hideKeyboard

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UiStateViewModel
    private lateinit var uiStateObserver: Observer<UiState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // viewModel = (application as MyApp).viewModel
        viewModel = ViewModelProvider(this)[UiStateViewModel::class.java]

        uiStateObserver = Observer {
            binding.weightInputEditText.clearFocus()
            when (it) {
                is UiState.ResultState -> {
                    binding.weightInputLayout.error = ""
                    binding.resultTextView.text =
                        getString(R.string.result_starting_text, it.result)

                    it.apply(
                        resultTextView = binding.resultTextView,
                        spacing = binding.spacing
                    )
                }

                is UiState.ErrorState -> {
                    binding.weightInputLayout.error = getString(R.string.empty_field)
                    it.apply(
                        resultTextView = binding.resultTextView,
                        spacing = binding.spacing
                    )
                }

                is UiState.CleanState -> {
                    binding.weightInputLayout.error = ""
                    binding.weightInputEditText.setText("")
                    it.apply(
                        resultTextView = binding.resultTextView,
                        spacing = binding.spacing
                    )
                }
            }
        }

        binding.calculateButton.setOnClickListener {
            hideKeyboard(binding.weightInputEditText)
            viewModel.calculate(binding.weightInputEditText.text.toString())
        }

        binding.clearButton.setOnClickListener {
            hideKeyboard(binding.weightInputEditText)
            viewModel.clearScreen()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveData.observe(this, uiStateObserver)
    }

    override fun onStop() {
        super.onStop()
        viewModel.liveData.removeObserver(uiStateObserver)
    }
}