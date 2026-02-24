package com.example.marketplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable fun HomeScreen(onProductClick: () -> Unit) {
    Column { Text("Pantalla 2: Catálogo (Retrofit)"); Button(onClick = onProductClick) { Text("Ver Producto") } }
}