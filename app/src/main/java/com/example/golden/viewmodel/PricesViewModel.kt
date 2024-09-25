package com.example.golden.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.golden.data.model.MetalPricesResponse
import com.example.golden.data.repository.PricesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PricesViewModel @Inject constructor(
    private val repository: PricesRepository
) : ViewModel() {

    private val _prices = mutableStateOf<MetalPricesResponse?>(null)
    val prices: State<MetalPricesResponse?> = _prices

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _isError = mutableStateOf<String?>(null)
    val isError: State<String?> = _isError

    init {
        getPrices()
    }

    fun getPrices(onFinished: () -> Unit = {}) {
        _isLoading.value = true
        _isError.value = null // Reset error before fetching data

        viewModelScope.launch {
            try {
                val response = repository.getMetalPrices()
                _prices.value = response
            } catch (e: Exception) {
                _isError.value = "Failed to fetch prices: ${e.message}"
            } finally {
                _isLoading.value = false
                onFinished()
            }
        }
    }
}
