package com.example.fineduca.screens

import ConfigOption
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fineduca.R
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.components.TopMenu

@Composable
fun ConfigScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        TopMenu()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Configurações",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            ConfigOption(
                title = "Conta",
                description = "Gerencie suas informações de conta",
                imagePainter = painterResource(id = R.drawable.baseline_person_pin_24),
                onClick = {  }
            )

            ConfigOption(
                title = "Notificações",
                description = "Configurar alertas e lembretes financeiros",
                imagePainter = painterResource(id = R.drawable.round_add_alert_24),
                onClick = {  }
            )

            ConfigOption(
                title = "Privacidade",
                description = "Controle de segurança e permissões",
                imagePainter = painterResource(id = R.drawable.baseline_browser_not_supported_24),
                onClick = {  }
            )

            ConfigOption(
                title = "Sobre",
                description = "Informações sobre o aplicativo",
                imagePainter = painterResource(id = R.drawable.baseline_back_hand_24),
                onClick = {  }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}