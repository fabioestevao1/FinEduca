package com.example.fineduca.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fineduca.R
import com.example.fineduca.calc.calcularJurosCompostos
import com.example.fineduca.calc.calcularJurosSimples
import com.example.fineduca.calc.calcularMontante
import com.example.fineduca.components.CardResultadoCompostos
import com.example.fineduca.components.CardResultadoSimples

@Composable
fun InvestmentSimulation() {
    var capital by remember { mutableStateOf("") }
    var taxa by remember { mutableStateOf("") }
    var tempo by remember { mutableStateOf("") }
    var cdi by remember { mutableStateOf("") }
    var percentualCDI by remember { mutableStateOf("") }
    var tipoInvestimento by remember { mutableStateOf("LCI") }
    var preFixado by remember { mutableStateOf(false) }

    var jurosSimples by remember { mutableStateOf(0.0) }
    var montanteSimples by remember { mutableStateOf(0.0) }
    var montanteBruto by remember { mutableStateOf(0.0) }
    var montanteLiquido by remember { mutableStateOf(0.0) }
    var impostoEstimado by remember { mutableStateOf(0.0) }

    var selectedCalculation by remember { mutableStateOf("Juros Simples") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
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

            // Seleção entre Juros Simples e Compostos
            DropdownMenuSelection(
                options = listOf("Juros Simples", "Juros Compostos"),
                selectedOption = selectedCalculation,
                onOptionSelected = { selectedCalculation = it }
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Entrada de dados
            InputField("Capital", capital) { capital = it }
            InputField("Taxa (%)", taxa) { taxa = it }
            InputField("Tempo (meses)", tempo) { tempo = it }

            if (selectedCalculation == "Juros Compostos") {
                InputField("CDI", cdi) { cdi = it }
                InputField("Percentual do CDI", percentualCDI) { percentualCDI = it }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = preFixado,
                        onCheckedChange = { preFixado = it }
                    )
                    Text("Pré-fixado", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão para Calcular
            Button(onClick = {
                if (selectedCalculation == "Juros Simples") {
                    jurosSimples = calcularJurosSimples(
                        capital.toDoubleOrNull() ?: 0.0,
                        taxa.toDoubleOrNull() ?: 0.0,
                        tempo.toDoubleOrNull() ?: 0.0
                    )
                    montanteSimples = calcularMontante(capital.toDoubleOrNull() ?: 0.0, jurosSimples)
                } else {
                    val resultado = calcularJurosCompostos(
                        capital.toDoubleOrNull() ?: 0.0,
                        cdi.toDoubleOrNull() ?: 0.0,
                        percentualCDI.toDoubleOrNull() ?: 0.0,
                        tempo.toDoubleOrNull() ?: 0.0,
                        tipoInvestimento,
                        preFixado,
                        taxa.toDoubleOrNull() ?: 0.0
                    )
                    montanteBruto = resultado.first
                    montanteLiquido = resultado.second
                    impostoEstimado = resultado.third
                }
            }) {
                Text("Calcular", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Exibição do resultado
            if (selectedCalculation == "Juros Simples") {
                CardResultadoSimples(juros = jurosSimples, montante = montanteSimples)
            } else {
                CardResultadoCompostos(montanteBruto = montanteBruto, montanteLiquido = montanteLiquido, imposto = impostoEstimado)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue -> onValueChange(newValue) },
        label = { Text(label, color = Color.White) }, // Cor do texto do rótulo
        textStyle = TextStyle(color = Color.White), // Cor do texto inserido
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.Gray,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.Gray,
            cursorColor = Color.White
        )
    )
}



@Composable
fun DropdownMenuSelection(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
            Text(selectedOption, color = Color.White)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    },
                    text = { Text(option, color = Color.Black) }
                )
            }
        }
    }
}
