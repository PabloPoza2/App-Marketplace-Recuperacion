package com.example.marketplace.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marketplace.Product

@Composable
fun DetailScreen(product: Product, onBack: () -> Unit, onAddToFavorites: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())) {
        coil.compose.AsyncImage(
            model = product.image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(300.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.height(16.dp))
        Text(product.title, style = MaterialTheme.typography.headlineMedium)
        Text("${product.price}€", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))
        Text(product.description, style = MaterialTheme.typography.bodyMedium)

        Spacer(Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                onAddToFavorites()
                onBack()
            }, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text("Añadir a Favoritos")
            }
            Button(onClick = { /* */ }, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text("Añadir a Cesta")
            }
        }
        TextButton(onClick = onBack, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Volver al Catálogo")
        }
    }
}