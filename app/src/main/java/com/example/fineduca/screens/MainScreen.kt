package com.example.fineduca.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.fineduca.R
import com.example.fineduca.components.BottomMenu
import com.example.fineduca.components.TextBox
import com.example.fineduca.components.TopMenu


//@Composable
//fun MainScreen() {
//    Box(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(colorResource(id = R.color.main_blue)),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            TopMenu()  // Menu superior
//            Spacer(modifier = Modifier.height(20.dp))
//            TextBox(
//                title = "Título 1",
//                text = "Caixa 1 - Navegar para outra tela",
//                onClick = { println("Caixa 1 clicada!") }
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            TextBox(
//                title = "Título 2",
//                text = "Caixa 2 - Configurações",
//                onClick = { println("Caixa 2 clicada!") }
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            TextBox(
//                title = "Título 3",
//                text = "Caixa 2 - Configurações",
//                onClick = { println("Caixa 2 clicada!") }
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//
//            BottomMenu(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .align(Alignment.End)
//            )
//        }
//    }
//}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
    ) {
        // Menu superior
        Spacer(modifier = Modifier.height(40.dp))
        TopMenu()
        Spacer(modifier = Modifier.height(20.dp))

        // Conteúdo principal que ocupa o espaço disponível
        Column(
            modifier = Modifier
                .weight(1f) // Ocupa o máximo de espaço disponível
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBox(
                title = "Título 1",
                text = "Caixa 1 - Navegar para outra tela",
                onClick = { println("Caixa 1 clicada!") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "Título 2",
                text = "Caixa 2 - Configurações",
                onClick = { println("Caixa 2 clicada!") }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextBox(
                title = "Título 3",
                text = "Caixa 3 - Configurações",
                onClick = { println("Caixa 3 clicada!") }
            )
        }

        // Menu inferior fixo
        BottomMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}
