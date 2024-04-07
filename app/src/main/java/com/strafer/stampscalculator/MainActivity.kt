package com.strafer.stampscalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        viewModel = (application as MyApp).viewModel
        // viewModel = ViewModelProvider(this)[UiStateViewModel::class.java]

        uiStateObserver = Observer {
            it.apply(
                binding.weightInputLayout,
                binding.resultTextView,
                binding.spacing
            )
        }

        binding.calculateButton.setOnClickListener {
            hideKeyboard(binding.weightInputEditText)
            viewModel.calculate(binding.weightInputEditText.text.toString())
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