package com.example.marketplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marketplace.screens.* import com.example.marketplace.ui.theme.MarketPlaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketPlaceTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel = remember {
        ProductViewModel(ProductRepository(RetrofitClient.instance))
    }


    val favoriteProducts = remember { mutableStateListOf<Product>() }
    var selectedProduct by remember { mutableStateOf<Product?>(null) }

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") {
                LoginScreen(onNavigate = { navController.navigate("home") })
            }

            composable("home") {
                HomeScreen(
                    viewModel = viewModel,
                    navController = navController,
                    onNavigateToProfile = { navController.navigate("profile") },
                    onProductClick = { product ->
                        selectedProduct = product
                        navController.navigate("detail")
                    }
                )
            }

            composable("detail") {
                selectedProduct?.let { item ->
                    DetailScreen(
                        product = item,
                        onBack = { navController.popBackStack() },
                        onAddToFavorites = {
                            if (!favoriteProducts.contains(item)) {
                                favoriteProducts.add(item)
                            }
                        }
                    )
                }
            }

            composable("favs") {
                FavoritesScreen(
                    favorites = favoriteProducts,
                    onBack = { navController.popBackStack() },
                    onProductClick = { product ->
                        selectedProduct = product
                        navController.navigate("detail")
                    }
                )
            }
            composable("profile") {
                ProfileScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToFavs = { navController.navigate("favs") }
                )
            }
        }
    }
}