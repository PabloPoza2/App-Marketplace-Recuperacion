package com.example.marketplace.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.marketplace.Product
import com.example.marketplace.ProductViewModel

@Composable
fun HomeScreen(
    viewModel: ProductViewModel,
    navController: NavHostController,
    onNavigateToProfile: () -> Unit,
    onProductClick: (Product) -> Unit
) {
    LaunchedEffect(Unit) { viewModel.fetchProducts() }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Button(onClick = onNavigateToProfile, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text("Perfil", fontSize = 10.sp)
            }
            Button(onClick = { navController.navigate("favs") }, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text("Favs", fontSize = 10.sp)
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(viewModel.products) { product ->
                Card(
                    modifier = Modifier.padding(8.dp).clickable { onProductClick(product) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column {
                        AsyncImage(
                            model = product.image,
                            contentDescription = product.title,
                            modifier = Modifier.fillMaxWidth().height(120.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(product.title, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(8.dp))
                        Text("${product.price}€", color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))
                    }
                }
            }
        }
    }
}