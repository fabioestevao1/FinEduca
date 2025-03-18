package com.example.fineduca.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        modifier = modifier
    ) {
        Text(text,color = textColor)
    }
}

@Composable
fun DarkButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        modifier = modifier,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = Color(0xFF384B65)
        ),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun LightButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        modifier = modifier,
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = Color(0xFF8EFE03)
        ),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
    ) {
        Text(text = text, color = Color(0xFF242831), fontSize = 16.sp)
    }
}