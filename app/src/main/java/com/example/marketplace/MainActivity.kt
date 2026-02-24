package com.example.marketplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
                // Inicia la navegación principal de la app
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Implementación de Arquitectura MVVM: El ViewModel sobrevive a recomposiciones
    val viewModel = remember {
        val apiService = RetrofitClient.instance
        val repository = ProductRepository(apiService)
        ProductViewModel(repository)
    }

    Scaffold { innerPadding ->
        // Configuración de las 5 pantallas requeridas por la rúbrica
        NavHost(
            navController = navController,
            startDestination = "login", // Punto de entrada: Login (Firebase Auth)
            modifier = Modifier.padding(innerPadding)
        ) {
            // 1. Pantalla de Login
            composable("login") {
                LoginScreen(onNavigate = { navController.navigate("home") })
            }

            composable("home") {
                HomeScreen(
                    viewModel = viewModel,
                    onNavigateToProfile = { navController.navigate("profile") },
                    navController = navController // Pásale el controller aquí
                )
            }

            // 3. Pantalla de Detalle
            composable("detail") {
                DetailScreen(onBack = { navController.popBackStack() })
            }

            // 4. Pantalla de Favoritos (Persistencia ROOM)
            composable("favs") {
                FavoritesScreen()
            }

            // 5. Pantalla de Perfil (Firebase Crashlytics)
            composable("profile") {
                ProfileScreen()
            }
        }
    }
}