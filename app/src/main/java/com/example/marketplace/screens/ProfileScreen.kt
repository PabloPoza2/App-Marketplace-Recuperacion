package com.example.marketplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ProfileScreen() {
    Column {
        Text("Perfil de Usuario")
        Button(onClick = {
            throw RuntimeException("Prueba de Crash para la Recuperación")
        }) {
            Text("Forzar error (Crashlytics)")
        }
    }
}