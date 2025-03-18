package com.example.fineduca.calc
fun CalcularJurosSimples(
    capital: Double,
    taxa: Double,  // Taxa fornecida em % ao ano
    tempo: Int  // Tempo fornecido em meses
): Double {
    val taxaMensal = taxa / 12 / 100  // Convertendo taxa anual para mensal (simples)
    return capital * taxaMensal * tempo
}

fun CalcularMontante(capital: Double, juros: Double): Double {
    return capital + juros
}