package com.example.fineduca.calc

import kotlin.math.pow

fun CalcularJurosCompostos(
    capital: Double,
    cdi: Double,
    percentualCDI: Double,
    tempo: Int, // Tempo em meses
    tipoInvestimento: String,
    preFixado: Boolean,
    taxa: Double = 0.0 // Opcional para pré-fixado
): Triple<Double, Double, Double> {

    val aliquotaIR = when {
        tempo <= 6 -> 0.225
        tempo <= 12 -> 0.20
        tempo <= 24 -> 0.175
        else -> 0.15
    }

    val taxaMensal = if (preFixado) {
        (1 + taxa / 100).pow(1.0 / 12) - 1  // Correta conversão da taxa anual para mensal
    } else {
        (1 + (cdi * (percentualCDI / 100)) / 100).pow(1.0 / 12) - 1  // CDI convertido para taxa mensal
    }

    val montanteBruto = capital * (1 + taxaMensal).pow(tempo)  // Aplicando a fórmula correta

    val impostoEstimado = when (tipoInvestimento.lowercase()) {
        "lci", "lca", "poupança" -> 0.0
        else -> (montanteBruto - capital) * aliquotaIR
    }

    val montanteLiquido = montanteBruto - impostoEstimado

    return Triple(montanteBruto, montanteLiquido, impostoEstimado)
}