package com.laraknife.interfazjetpackcompose1.viewmodel.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.laraknife.interfazjetpackcompose1.R
import com.laraknife.interfazjetpackcompose1.navigation.AppScreens
import com.laraknife.interfazjetpackcompose1.viewmodel.data.ViewModel

@Composable
fun Login(navController: NavHostController, viewModel: ViewModel) {
    val mail: String by viewModel.mail.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val valido: Boolean by viewModel.valido.observeAsState(initial = false)
    val img = painterResource(R.drawable.control)
    val visible = painterResource(R.drawable.visible)
    val invisible = painterResource(R.drawable.invisible)
    var hidden by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    color = Color(0xFFF24949)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = img,
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
                Text(
                    text = "FIREBASE MVVM",
                    fontSize = 20.sp,
                    color = Color(0xFFDDDCDD),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFF1A1A1B)
                ),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(modifier = Modifier.padding(bottom = 24.dp)) {
                Text(
                    text = "¿No tienes una cuenta?",
                    color = Color(0xFF7F7E7F)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "REGISTRATE AQUI",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF890003),
                    modifier = Modifier.clickable {
                        viewModel.reset()
                        navController.navigate(route = AppScreens.Register.route)
                    }
                )
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp, start = 20.dp, end = 20.dp, bottom = 150.dp)
            .background(
                color = Color(0xFF262626)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "LOGIN",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFFDDDCDD)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Por favor inicia sesión para continuar",
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                color = Color(0xFF7F7E7F)
            )
            Spacer(modifier = Modifier.height(22.dp))
            OutlinedTextField(
                value = mail,
                onValueChange = {
                    viewModel.changeMail(it)
                    viewModel.verifyLogin()
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Correo Electrónico", color = Color(0xFF7F7E7F))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = null,
                        tint = Color(0xFFDDDCDD)
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {
                    viewModel.changePassword(it)
                    viewModel.verifyLogin()
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Contraseña", color = Color(0xFF7F7E7F))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = Color(0xFFDDDCDD)
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                visualTransformation = if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = { hidden = !hidden }) {
                        val icono =
                            if (hidden) {
                                invisible
                            } else {
                                visible
                            }
                        Icon(painter = icono, contentDescription = null)
                    }
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navController.navigate(route = AppScreens.Home.route)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = valido
            ) {
                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
                Text(text = "INICIAR SESIÓN", modifier = Modifier.padding(12.dp))
            }
        }
    }
}