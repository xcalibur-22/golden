package com.example.golden

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.golden.ui.PricesScreen
import dagger.hilt.android.AndroidEntryPoint
import com.example.golden.viewmodel.PricesViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PricesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PricesScreen(viewModel)
        }
    }
}

