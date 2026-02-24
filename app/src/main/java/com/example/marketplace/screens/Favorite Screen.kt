package com.example.marketplace.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable fun FavoritesScreen() { Text("Pantalla 4: Favoritos (ROOM)")
    Button(onClick = {
        throw RuntimeException("Prueba de Crash para la Recuperación")
    }) {
        Text("Forzar error (Crashlytics)")
    }
}