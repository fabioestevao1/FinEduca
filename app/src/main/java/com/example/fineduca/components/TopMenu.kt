package com.example.fineduca.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fineduca.ui.theme.MainBlue


@Composable
fun TopMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(MainBlue)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        // Saudação à esquerda
        Text(
            text = "Olá, João",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        // Nível à direita
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Nível 1",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Iniciante",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}
