package com.example.golden.data.model

data class MetalPricesResponse(
    val status: String,
    val authority: String,
    val currency: String,
    val unit: String,
    val timestamp: String,
    val rates: Rates
)

data class Rates(
    val mcx_gold: Double,
    val mcx_silver: Double,
    val mcx_gold_am: Double,
    val mcx_gold_pm: Double,
    val mcx_silver_am: Double,
    val mcx_silver_pm: Double
)
