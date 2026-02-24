package com.example.marketplace.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(onBack: () -> Unit, onNavigateToFavs: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Black),
            contentAlignment = Alignment.BottomCenter
        ) {

            Surface(
                modifier = Modifier.size(100.dp).offset(y = 50.dp),
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 4.dp
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp).fillMaxSize(),
                    tint = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(60.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Nombre Usuario", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Usuario Premium", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .width(150.dp)
                .height(100.dp),
            onClick = onNavigateToFavs
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Default.Favorite, contentDescription = null, tint = Color(0xFF5D0E23))
                Text("Favoritos", fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.weight(1f))


        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Button(
                onClick = { throw RuntimeException("Test Crash") }, // Botón CRASH
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Boton CRASH (Firebase)")
            }

            TextButton(
                onClick = onBack,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Volver al Catálogo")
            }
        }
    }
}