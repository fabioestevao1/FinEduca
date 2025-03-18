package com.example.fineduca.components

import androidx.compose.runtime.MutableState

fun validarDados(
    capital: String,
    taxa: String,
    tempo: String,
    cdi: String?,
    percentualCDI: String?,
    tipoInvestimento: String,
    preFixado: Boolean,
    mensagemErro: MutableState<String> // Agora é MutableState
): Boolean {
    mensagemErro.value = ""  // Limpar qualquer mensagem de erro anterior

    // Verificar se campos básicos (capital, taxa e tempo) estão preenchidos
    if (capital.isEmpty() || taxa.isEmpty() || tempo.isEmpty()) {
        mensagemErro.value = "Por favor, preencha todos os campos obrigatórios."
        return false
    }

    // Tentar converter os valores para Double e verificar se são válidos
    try {
        val capitalDouble = capital.toDoubleOrNull() ?: return false.apply {
            mensagemErro.value = "Capital deve ser um número válido."
        }
        val taxaDouble = taxa.toDoubleOrNull() ?: return false.apply {
            mensagemErro.value = "Taxa deve ser um número válido."
        }
        val tempoDouble = tempo.toDoubleOrNull() ?: return false.apply {
            mensagemErro.value = "Tempo deve ser um número válido."
        }

        if (capitalDouble <= 0 || taxaDouble <= 0 || tempoDouble <= 0) {
            mensagemErro.value = "Os valores de Capital, Taxa e Tempo devem ser maiores que zero."
            return false
        }

        // Verificação adicional para CDI e percentualCDI, se necessário
        if (tipoInvestimento != "LCI/LCA" && tipoInvestimento != "Poupança") {
            if (cdi.isNullOrEmpty() || percentualCDI.isNullOrEmpty()) {
                mensagemErro.value = "Por favor, preencha o CDI e o Percentual do CDI."
                return false
            }
            val cdiDouble = cdi.toDoubleOrNull() ?: return false.apply {
                mensagemErro.value = "CDI deve ser um número válido."
            }
            val percentualCDIDouble = percentualCDI.toDoubleOrNull() ?: return false.apply {
                mensagemErro.value = "Percentual do CDI deve ser um número válido."
            }

            if (cdiDouble <= 0 || percentualCDIDouble <= 0) {
                mensagemErro.value = "Os valores de CDI e Percentual do CDI devem ser maiores que zero."
                return false
            }
        }

        // Se for pré-fixado, não precisamos de CDI e Percentual do CDI
        if (preFixado && (cdi?.isNotEmpty() == true || percentualCDI?.isNotEmpty() == true)) {
            mensagemErro.value = "Você selecionou pré-fixado, portanto não precisa informar o CDI e o Percentual do CDI."
            return false
        }

    } catch (e: Exception) {
        mensagemErro.value = "Por favor, insira valores numéricos válidos."
        return false
    }

    // Se todas as validações passarem
    return true
}
