package com.example.fineduca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fineduca.R
import com.example.fineduca.calc.CalcularJurosCompostos
import com.example.fineduca.calc.CalcularJurosSimples
import com.example.fineduca.calc.CalcularPreFixado
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.components.CardResultadoCompostos
import com.example.fineduca.components.CardResultadoSimples
import com.example.fineduca.components.DropdownMenuSelection
import com.example.fineduca.components.InputField
import com.example.fineduca.components.ToggleButton
import com.example.fineduca.ui.theme.MainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestmentSimulation(navController: NavController) {
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
            // Top App Bar with Back Button
            TopAppBar(
                title = {
                    Text(
                        text = "Simulação de Investimentos",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.main_blue))

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
                    Text(
                        "Pré-fixado",
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
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
                                val (montanteBruto, montanteLiquido, imposto) = CalcularPreFixado(
                                    capitalValue,
                                    taxaValue,
                                    tempoValue
                                )
                                resultadoFinal = montanteLiquido
                            } else {
                                val cdiDouble = cdi.toDoubleOrNull() ?: 0.0
                                val percentualCDIDouble = percentualCDI.toDoubleOrNull() ?: 0.0
                                val (montanteBruto, montanteLiquido, imposto) = CalcularJurosCompostos(
                                    capitalValue,
                                    cdiDouble,
                                    percentualCDIDouble,
                                    tempoValue,
                                    tipoInvestimento,
                                    preFixado
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
                Text("Calcular", color = MainBlue, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Exibir resultados
            val capitalDouble = capital.toDoubleOrNull() ?: 0.0
            if (selectedCalculation == "Juros Simples") {
                CardResultadoSimples(resultadoFinal - capitalDouble, resultadoFinal)
            } else {
                CardResultadoCompostos(resultadoFinal, resultadoFinal, 0.0)
            }
        }
    }

    // Adicionar o Menu Inferior (BottomMenu)
    BottomMenu(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
