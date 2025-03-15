package com.example.fineduca.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.fineduca.R
import androidx.compose.foundation.layout.Arrangement

@Composable
fun MainScreen() {
    val backgroundImage = painterResource(id = R.drawable.home_image)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = "Home Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 16.dp, end = 16.dp, bottom = 140.dp, start = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Finanças simples,\nvida melhor.",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 60.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {  },
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF384B65)
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Cadastre-se", fontSize = 16.sp)
                }

                Button(
                    onClick = { },
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8EFE03)
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(text = "Acessar", color = Color(0xFF242831), fontSize = 16.sp)
                }
            }
        }
    }
}
