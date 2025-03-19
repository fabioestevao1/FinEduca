import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fineduca.R
import com.example.fineduca.components.DarkButton
import com.example.fineduca.components.LightButton


@Composable
fun GradientBackgroundRegisterScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF242831),
                        Color(0xFF384B65),
                        Color(0xFFBEFE03),
                        Color(0xFF8EFE03),
                        Color(0xFFC4C4CC)
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
                            Color(0xFF242831).copy(alpha = 0.2f),
                            Color.Transparent
                        )
                    )
                )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var agreedToTerms by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main_blue))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FinEduca",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 80.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Simplificando a Educação Financeira",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(68.dp))

        Text(
            text = "Cadastro",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "Nome",
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                BasicTextField(
                    value = name,
                    onValueChange = { name = it },
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
                            if (name.isEmpty()) {
                                Text(
                                    text = "Digite seu Nome",
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

                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Email",
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

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

                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Senha",
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp,
                modifier = Modifier.padding(end = 8.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                BasicTextField(
                    value = password,
                    onValueChange = { password = it },
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
                            if (password.isEmpty()) {
                                Text(
                                    text = "***************",
                                    color = Color.Gray,
                                    fontFamily = poppinsFontFamily,
                                    fontSize = 16.sp
                                )
                            }
                            innerTextField()
                        }
                    },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation()
                )

                Divider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = agreedToTerms,
                onCheckedChange = { agreedToTerms = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF8EFE03)
                )
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFFFFFFFF))){
                        append("De acordo com nossos ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF8EFE03))) {
                        append("Termos de Serviço")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFFFFFFFF))){
                        append(" e ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF8EFE03))) {
                        append("Política de Privacidade")
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(75.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DarkButton("Voltar", modifier = Modifier.width(135.dp).height(50.dp)) {
                navController.navigate("main_screen")
            }
            LightButton("Próximo", modifier = Modifier.width(135.dp).height(50.dp)) {
                navController.navigate("home_screen")
            }
        }

    }
}