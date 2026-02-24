package com.example.marketplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable fun DetailScreen(onBack: () -> Unit) {
    Column { Text("Pantalla 3: Detalle"); Button(onClick = onBack) { Text("Volver") } }
}