package com.strafer.stampscalculator

import android.app.Application
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.strafer.stampscalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: UiStateViewModel
    private lateinit var uiStateObserver: Observer<UiState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = (Application() as MyApp).viewModel

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

fun AppCompatActivity.hideKeyboard(view: View) {
    val imm = this.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}