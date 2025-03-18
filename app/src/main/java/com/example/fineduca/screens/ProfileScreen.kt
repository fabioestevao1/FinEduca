package com.example.fineduca.screens

import ProfileOption
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fineduca.R
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.components.TopMenu
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController


@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        TopMenu()

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_person_pin_24),
                contentDescription = "Foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                alpha = 0.9f
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "João da Silva",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "joao.silva@email.com",
            fontSize = 14.sp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Spacer(modifier = Modifier.height(32.dp))

        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            ProfileOption(
                title = "Alterar Foto de Perfil",
                onClick = {  }
            )
            ProfileOption(
                title = "Alterar Email",
                onClick = {  }
            )
            ProfileOption(
                title = "Alterar Senha",
                onClick = {  }
            )
            ProfileOption(
                title = "Ajuda e Suporte",
                onClick = {  }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            navController
        )
    }
}