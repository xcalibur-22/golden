package com.example.golden.data.repository

import com.example.golden.data.api.Network
import com.example.golden.data.model.MetalPricesResponse

class PricesRepository(private val apiKey: String) {
    suspend fun getMetalPrices(): MetalPricesResponse {
        return Network.pricesApi.getMetalPrices(
            apiKey = apiKey,
            authority = "mcx",
            currency = "INR",
            unit = "g"
        )
    }
}
