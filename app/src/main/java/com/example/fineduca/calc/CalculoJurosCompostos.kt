package com.example.fineduca.calc
fun calcularJurosCompostos(
    capital: Double,
    cdi: Double,
    percentualCDI: Double,
    tempo: Double, // Tempo em meses
    tipoInvestimento: String,
    preFixado: Boolean,
    taxa: Double = 0.0 // Opcional para pré-fixado
): Triple<Double, Double, Double> {
    // Definir a alíquota do imposto de renda com base no tempo
    val aliquotaIR = when {
        tempo <= 6 -> 0.225  // Até 6 meses: 22,5%
        tempo > 6 && tempo <= 12 -> 0.20  // De 6 a 12 meses: 20%
        tempo > 12 && tempo <= 24 -> 0.175 // De 12 a 24 meses: 17,5%
        else -> 0.15  // Acima de 24 meses: 15%
    }

    // Calcula a taxa com base no CDI ou usa a taxa fixa se for pré-fixado
    val taxa = if (preFixado) {
        taxa / 100
    } else {
        (cdi * (percentualCDI / 100)) / 100
    }

    // Montante bruto
    val montanteBruto = capital * Math.pow(1 + taxa, tempo / 12) // Convertendo meses para anos

    // Calcula imposto apenas para investimentos que não são isentos
    val impostoEstimado = when (tipoInvestimento.lowercase()) {
        "lci", "lca", "poupança" -> 0.0
        else -> (montanteBruto - capital) * aliquotaIR
    }

    // Montante líquido (com imposto descontado)
    val montanteLiquido = montanteBruto - impostoEstimado

    return Triple(montanteBruto, montanteLiquido, impostoEstimado)
}
