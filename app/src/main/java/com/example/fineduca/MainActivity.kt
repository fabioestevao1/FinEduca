package com.example.fineduca

//import LoginScreen
//import RegisterScreen
//import PasswordScreen
//import com.example.fineduca.screens.QuotationScreen
import com.example.fineduca.screens.HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.fineduca.ui.theme.FinEducaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinEducaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HomeScreen() // Adicione a HomeScreen aqui

//                    QuotationScreen()

//                    RegisterScreen(
//                        onBack = { /* Handle back action */ },
//                        onNext = { name, email, password ->
//                            // Handle login logic
//                        }
//                    )
//                    LoginScreen(
//                        onBack = { /* Handle back action */ },
//                        onLogin = { email, password ->
//                            // Handle login logic
//                        }
//                    )
//                    PasswordScreen(
//                        onBack = { /* Handle back action */ },
//                        onNext = { email ->
//                            // Handle login logic
//                        }
//                    )
                }
            }
        }
    }
}