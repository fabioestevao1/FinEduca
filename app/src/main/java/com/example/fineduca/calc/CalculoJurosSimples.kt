package com.example.fineduca.calc

fun calcularJurosSimples(
    capital: Double,
    taxa: Double,
    tempo: Double
): Double {
    return capital * taxa /100 * tempo
}

fun calcularMontante(capital: Double, juros:Double): Double {
    return capital+juros
}