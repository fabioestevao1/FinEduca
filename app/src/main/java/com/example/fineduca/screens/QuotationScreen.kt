package com.example.fineduca.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fineduca.R
import com.example.fineduca.model.CurrencyResponse
import com.example.fineduca.network.RetrofitClient
import kotlinx.coroutines.launch
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.components.TopMenu
import java.net.UnknownHostException

@Composable
fun QuotationScreen(navController: NavController) {
    var currencyData by remember { mutableStateOf<CurrencyResponse?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            try {
                val response = RetrofitClient.instance.getCurrencyQuotes()
                currencyData = response
                isLoading = false
            } catch (e: Exception) {
                errorMessage = when {
                    e is UnknownHostException -> "Erro de conexão: Verifique sua internet."
                    else -> "Erro ao buscar cotações: ${e.message}"
                }
                isLoading = false
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        TopMenu()

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoading) {
                Text("Carregando...", color = Color.White)
            } else if (errorMessage != null) {
                Text(errorMessage!!, color = Color.Red)
            } else {
                currencyData?.let { data ->
                    CurrencyCard(
                        currencyCode = "USD",
                        currencyName = data.USDBRL.name,
                        bidValue = data.USDBRL.bid
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    CurrencyCard(
                        currencyCode = "EUR",
                        currencyName = data.EURBRL.name,
                        bidValue = data.EURBRL.bid
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    CurrencyCard(
                        currencyCode = "BTC",
                        currencyName = data.BTCBRL.name,
                        bidValue = data.BTCBRL.bid
                    )
                }
            }
        }

        BottomMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), navController
        )
    }
}

@Composable
fun CurrencyCard(
    currencyCode: String,
    currencyName: String,
    bidValue: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF8EFE03)
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = currencyCode,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = currencyName,
                color = Color.Black,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Valor: R$ $bidValue",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
