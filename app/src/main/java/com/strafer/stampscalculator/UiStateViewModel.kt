package com.strafer.stampscalculator

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.strafer.stampscalculator.utilities.Calculator

class UiStateViewModel : ViewModel() {

    var liveData = MutableLiveData<UiState>()
        private set

    private val calculator: Calculator = Calculator()

    fun calculate(weight: String) {
        if (weight.trim().isEmpty()) {
            liveData.value = UiState.Error()
        } else {
            liveData.value = UiState.Success(
                calculator.calculateWeight(weight.toDouble())
            )
        }

    }
}