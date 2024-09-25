package com.example.golden.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.metals.dev/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val pricesApi: PricesApi = retrofit.create(PricesApi::class.java)
}
