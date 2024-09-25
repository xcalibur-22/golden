package com.example.golden.data.api

import com.example.golden.data.model.MetalPricesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PricesApi {
    @GET("v1/metal/authority")
    suspend fun getMetalPrices(
        @Query("api_key") apiKey: String,
        @Query("authority") authority: String,
        @Query("currency") currency: String,
        @Query("unit") unit: String
    ): MetalPricesResponse
}
