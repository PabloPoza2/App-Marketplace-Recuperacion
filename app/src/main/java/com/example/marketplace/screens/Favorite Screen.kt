package com.example.marketplace.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marketplace.Product

@Composable
fun FavoritesScreen(
    favorites: List<Product>,
    onBack: () -> Unit,
    onProductClick: (Product) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Mis Favoritos", style = MaterialTheme.typography.headlineLarge)

        if (favorites.isEmpty()) {
            Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text("No tienes favoritos aún")
            }
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(favorites) { product ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onProductClick(product) }
                    ) {
                        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model = product.image,
                                contentDescription = null,
                                modifier = Modifier.size(80.dp),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.width(16.dp))
                            Column {
                                Text(product.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                                Text("${product.price}€", color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }
        }

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Volver al Catálogo")
        }
    }
}