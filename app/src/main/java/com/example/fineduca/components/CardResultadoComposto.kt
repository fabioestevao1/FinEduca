package com.example.fineduca.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fineduca.ui.theme.MainBlue
import com.example.fineduca.ui.theme.MainGreen

@Composable
fun CardResultadoCompostos(montanteBruto: Double, montanteLiquido: Double, imposto: Double) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MainBlue)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Resultado utilizando Juros Compostos:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Montante Bruto:",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "R$ %.2f".format(montanteBruto),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MainGreen
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Imposto Estimado:",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "R$ %.2f".format(imposto),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MainGreen
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Montante Líquido:",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "R$ %.2f".format(montanteLiquido),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MainGreen
                )
            }
        }
    }
}
