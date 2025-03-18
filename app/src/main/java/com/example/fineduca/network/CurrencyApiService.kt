package com.example.fineduca.network // Ajuste o pacote conforme necessário

import com.example.fineduca.model.CurrencyResponse
import retrofit2.http.GET
import retrofit2.Call

interface CurrencyApiService {
    @GET("json/last/USD-BRL,EUR-BRL,BTC-BRL")
    suspend fun getCurrencyQuotes(): CurrencyResponse
}