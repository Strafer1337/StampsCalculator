package com.strafer.stampscalculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class UiStateViewModel : ViewModel() {

    val liveData = UiStateLiveData()

    fun calculate(weight: String) {
        if (weight.trim().isEmpty()){
            liveData.setValueToLiveData(UiState.Error)
        } else {
            liveData.setValueToLiveData(UiState.Success)
        }

    }
}