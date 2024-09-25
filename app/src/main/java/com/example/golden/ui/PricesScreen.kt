package com.example.golden.ui

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.golden.viewmodel.PricesViewModel
import kotlin.math.round

@Composable
fun PricesScreen(viewModel: PricesViewModel) {
    val prices = viewModel.prices.value
    val isLoading by viewModel.isLoading
    val isError by viewModel.isError
    var showLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading || isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(64.dp))
        } else {
            isError?.let {
                Text("Error: $it")
            }

            prices?.let {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PriceCard("Gold: ₹${(it.rates.mcx_gold) * 10}")
                    PriceCard("Silver: ₹${(it.rates.mcx_silver) * 1000}")
                    Spacer(modifier = Modifier.height(16.dp))
                }
            } ?: Text("Loading prices...")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                showLoading = true
                viewModel.getPrices {
                    showLoading = false
                }
            }) {
                Text("Refresh")
            }
        }
    }
}

@Composable
fun PriceCard(title: String) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
        )
    }
}



