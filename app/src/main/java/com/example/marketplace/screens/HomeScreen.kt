package com.example.marketplace.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding // IMPORTANTE
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp // IMPORTANTE
import androidx.compose.ui.unit.sp
import com.example.marketplace.ProductViewModel

@Composable
fun HomeScreen(viewModel: ProductViewModel, onNavigateToProfile: () -> Unit, navController: androidx.navigation.NavController) {
    // Carga los datos de la API al iniciar
    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // --- FILA DE BOTONES PARA LA DEFENSA ---
        Row(modifier = Modifier.padding(8.dp)) {
            Button(onClick = { navController.navigate("profile") }, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text("Perfil", fontSize = 10.sp)
            }
            Button(onClick = { navController.navigate("favs") }, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text("Favs", fontSize = 10.sp)
            }
            Button(onClick = { navController.navigate("detail") }, modifier = Modifier.weight(1f).padding(4.dp)) {
                Text("Detalle", fontSize = 10.sp)
            }
        }

        Text("Catálogo de Productos", modifier = Modifier.padding(start = 16.dp))

        // --- LISTA DE ROPA ---
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(viewModel.products) { product ->
                Text(
                    text = "${product.title} - ${product.price}€",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}