package com.laraknife.interfazjetpackcompose1.viewmodel.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.laraknife.interfazjetpackcompose1.navigation.AppScreens
import com.laraknife.interfazjetpackcompose1.viewmodel.data.ViewModel

@Composable
fun Home(navController: NavHostController, viewModel: ViewModel) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .background(color = Color(0xFFF24949))
                    .fillMaxWidth()
                    .height(50.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color(0xFFDDDCDD),
                    modifier = Modifier
                        .padding(12.dp)
                        .clickable {
                            viewModel.reset()
                            navController.navigate(route = AppScreens.Login.route)
                        }
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Home Info Usuario",
                    color = Color(0xFFDDDCDD),
                    fontWeight = FontWeight.Bold
                )
            }
        },
        content = { innerPaddingValues ->
            verInfoUsuario(innerPaddingValues, viewModel)
        }
    )
}

@Composable
fun verInfoUsuario(innerPaddingValues: PaddingValues, viewModel: ViewModel){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues = innerPaddingValues)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Usuario")
            Spacer(modifier = Modifier.width(14.dp))
            Text(text = viewModel.user.value.toString())
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Correo")
            Spacer(modifier = Modifier.width(14.dp))
            Text(text = viewModel.mail.value.toString())
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Contraseña")
            Spacer(modifier = Modifier.width(14.dp))
            Text(text = viewModel.password.value.toString())
        }
    }
}