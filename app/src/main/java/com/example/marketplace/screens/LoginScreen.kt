package com.example.marketplace.screens

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column

@Composable fun LoginScreen(onNavigate: () -> Unit) {
    Column { Text("Pantalla 1: Login (Firebase)"); Button(onClick = onNavigate) { Text("Entrar") } }
}

