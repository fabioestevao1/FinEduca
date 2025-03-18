package com.example.fineduca.model // Ajuste o pacote conforme necessário

data class CurrencyResponse(
    val USDBRL: CurrencyInfo,
    val EURBRL: CurrencyInfo,
    val BTCBRL: CurrencyInfo
)

data class CurrencyInfo(
    val code: String,
    val codein: String,
    val name: String,
    val high: String,
    val low: String,
    val bid: String,
    val create_date: String
)