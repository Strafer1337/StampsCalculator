package com.strafer.stampscalculator

import android.app.Application
import com.strafer.stampscalculator.presentation.UiStateViewModel

class MyApp : Application() {
    val viewModel = UiStateViewModel()
}