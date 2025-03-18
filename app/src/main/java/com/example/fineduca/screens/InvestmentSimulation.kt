package com.example.fineduca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fineduca.R
import com.example.fineduca.calc.CalcularJurosSimples
import com.example.fineduca.calc.CalcularJurosCompostos
import com.example.fineduca.calc.CalcularPreFixado
import com.example.fineduca.components.CardResultadoSimples
import com.example.fineduca.components.CardResultadoCompostos
import com.example.fineduca.components.DropdownMenuSelection
import com.example.fineduca.components.InputField
import com.example.fineduca.components.ToggleButton

@Composable
fun InvestmentSimulation() {
    var capital by remember { mutableStateOf("") }
    var taxa by remember { mutableStateOf("") }
    var tempo by remember { mutableStateOf("") }
    var cdi by remember { mutableStateOf("") }
    var percentualCDI by remember { mutableStateOf("") }
    var tipoInvestimento by remember { mutableStateOf("LCI/LCA") }
    var preFixado by remember { mutableStateOf(false) }
    var selectedCalculation by remember { mutableStateOf("Juros Simples") }
    var resultadoFinal by remember { mutableStateOf(0.0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Título
            Text(
                text = "Simulação de Investimentos",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                lineHeight = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Botões para selecionar tipo de juros
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ToggleButton(
                    text = "Juros Simples",
                    isSelected = selectedCalculation == "Juros Simples",
                    onClick = { selectedCalculation = "Juros Simples" }
                )
                ToggleButton(
                    text = "Juros Compostos",
                    isSelected = selectedCalculation == "Juros Compostos",
                    onClick = { selectedCalculation = "Juros Compostos" }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campos de entrada para valores
            InputField("Capital", capital) { capital = it }
            InputField("Taxa (%)", taxa) { taxa = it }
            InputField("Tempo (meses)", tempo) { tempo = it }

            // Campos específicos para "Juros Compostos"
            if (selectedCalculation == "Juros Compostos") {
                DropdownMenuSelection(
                    options = listOf("LCI/LCA", "CDB", "Poupança", "Fundo de Investimento"),
                    selectedOption = tipoInvestimento,
                    onOptionSelected = { tipoInvestimento = it }
                )

                if (!preFixado) {
                    InputField("CDI", cdi) { cdi = it }
                    InputField("Percentual do CDI", percentualCDI) { percentualCDI = it }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Checkbox(
                        checked = preFixado,
                        onCheckedChange = { preFixado = it }
                    )
                    Text("Pré-fixado", color = Color.White, modifier = Modifier.padding(start = 8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão para calcular
            Button(
                onClick = {
                    val capitalValue = capital.toDoubleOrNull() ?: 0.0
                    val taxaValue = taxa.toDoubleOrNull() ?: 0.0
                    val tempoValue = tempo.toIntOrNull() ?: 0

                    if (capitalValue != 0.0 && taxaValue != 0.0 && tempoValue != 0) {
                        if (selectedCalculation == "Juros Simples") {
                            val juros = CalcularJurosSimples(capitalValue, taxaValue, tempoValue)
                            val montante = capitalValue + juros
                            resultadoFinal = montante
                        } else if (selectedCalculation == "Juros Compostos") {
                            if (preFixado) {
                                val (montanteBruto, montanteLiquido, imposto) = CalcularPreFixado(capitalValue, taxaValue, tempoValue)
                                resultadoFinal = montanteLiquido
                            } else {
                                val cdiDouble = cdi.toDoubleOrNull() ?: 0.0
                                val percentualCDIDouble = percentualCDI.toDoubleOrNull() ?: 0.0
                                val (montanteBruto, montanteLiquido, imposto) = CalcularJurosCompostos(
                                    capitalValue, cdiDouble, percentualCDIDouble, tempoValue, tipoInvestimento, preFixado
                                )
                                resultadoFinal = montanteLiquido
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.main_green))
            ) {
                Text("Calcular", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Exibir resultados
            if (selectedCalculation == "Juros Simples") {
                CardResultadoSimples(resultadoFinal - capital.toDoubleOrNull()!!, resultadoFinal)
            } else {
                CardResultadoCompostos(resultadoFinal, resultadoFinal, 0.0)
            }
        }
    }
}
