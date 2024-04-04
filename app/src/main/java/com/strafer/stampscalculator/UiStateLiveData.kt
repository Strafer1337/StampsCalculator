package com.strafer.stampscalculator

import androidx.lifecycle.LiveData
import com.strafer.stampscalculator.UiState

class UiStateLiveData: LiveData<UiState>() {

    fun setValueToLiveData (state: UiState) {
        value = state
    }
}