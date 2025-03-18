package com.example.fineduca.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.fineduca.R

@Composable
fun ToggleButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.White else colorResource(id = R.color.main_blue),
            contentColor = if (isSelected) colorResource(id = R.color.main_blue) else Color.White
        )
    ) {
        Text(text)
    }
}