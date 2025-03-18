package com.example.fineduca.calc

import kotlin.math.pow

fun CalcularPreFixado(
    capital: Double,
    taxaAnual: Double,  // Taxa em % ao ano
    tempo: Int  // Tempo em meses
): Triple<Double, Double, Double> {

    val taxaMensal = (1 + taxaAnual / 100).pow(1.0 / 12) - 1  // Correta conversão da taxa anual para mensal

    val montanteBruto = capital * (1 + taxaMensal).pow(tempo)  // Aplicando a fórmula correta

    val imposto = when {
        tempo <= 6 -> (montanteBruto - capital) * 0.225
        tempo <= 12 -> (montanteBruto - capital) * 0.20
        tempo <= 24 -> (montanteBruto - capital) * 0.175
        else -> (montanteBruto - capital) * 0.15
    }

    val montanteLiquido = montanteBruto - imposto

    return Triple(montanteBruto, montanteLiquido, imposto)
}