package com.laraknife.interfazjetpackcompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.laraknife.interfazjetpackcompose1.navigation.AppNavigation
import com.laraknife.interfazjetpackcompose1.theme.InterfazJetpackCompose1Theme
import com.laraknife.interfazjetpackcompose1.viewmodel.data.ViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfazJetpackCompose1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(ViewModel())
                }
            }
        }
    }
}