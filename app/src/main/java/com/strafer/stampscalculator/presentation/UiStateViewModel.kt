package com.strafer.stampscalculator.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.strafer.stampscalculator.utilities.Calculator

class UiStateViewModel : ViewModel() {

    var liveData = MutableLiveData<UiState>(UiState.CleanState())
        private set

    private val calculator: Calculator = Calculator()

    fun calculate(weight: String) {
        if (weight.trim().isEmpty()) {
            liveData.value = UiState.ErrorState()
        } else {
            liveData.value = UiState.ResultState(
                calculator.calculateWeight(weight.toDouble())
            )
        }
    }

    fun clearScreen() {
        liveData.value = UiState.CleanState()
    }
}