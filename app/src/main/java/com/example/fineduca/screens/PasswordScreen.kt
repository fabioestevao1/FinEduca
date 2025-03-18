import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.fineduca.R
import com.example.fineduca.components.DarkButton
import com.example.fineduca.components.LightButton

@Composable
fun GradientBackgroundPasswordScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF242831), // Cor escura
                        Color(0xFF384B65), // Cor mais clara
                        Color(0xFFBEFE03), // Cor verde
                        Color(0xFF8EFE03),  // Outra cor verde
                        Color(0xFFC4C4CC)   // Cor cinza
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF242831).copy(alpha = 0.2f), // Camada escura com 20% de opacidade
                            Color.Transparent // Transparente para manter a base visível
                        )
                    )
                )
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordScreen(onBack: () -> Unit, onNext: (String) -> Unit) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título principal
        Text(
            text = "Esqueceu a Senha?",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = poppinsFontFamily, // Aplica a fonte Poppins
                fontWeight = FontWeight.Bold // Aplica o negrito
            ),
            modifier = Modifier.padding(top = 80.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Instrução
        Text(
            text = "Digite sua conta de e-mail para redefinir sua senha",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(90.dp))

        Image(
            painter = painterResource(id = R.drawable.carta), // Substitua "carta" pelo nome da sua imagem
            contentDescription = "Imagem de uma carta", // Descrição para acessibilidade
            modifier = Modifier
                .size(175.dp) // Define o tamanho da imagem
                .padding(8.dp) // Adiciona um espaçamento ao redor da imagem
        )

        Spacer(modifier = Modifier.height(90.dp))

        // Campo de email
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Rótulo "Email"
            Text(
                text = "Email",
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

            // Campo de texto com placeholder e linha
            Column(
                modifier = Modifier.weight(1f)
            ) {
                BasicTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    textStyle = LocalTextStyle.current.copy(
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontSize = 16.sp
                    ),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            if (email.isEmpty()) {
                                Text(
                                    text = "Digite seu Email",
                                    color = Color.Gray,
                                    fontFamily = poppinsFontFamily,
                                    fontSize = 16.sp
                                )
                            }
                            innerTextField()
                        }
                    },
                    singleLine = true
                )

                // Linha branca
                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        // Botões de navegação
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DarkButton("Voltar", modifier = Modifier
                .width(135.dp)
                .height(50.dp)
            )

            LightButton("Próximo", modifier = Modifier
                .width(135.dp)
                .height(50.dp)
            )
        }
    }
}