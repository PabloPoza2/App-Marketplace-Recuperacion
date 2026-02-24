package com.example.marketplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
// Asegúrate de que estos nombres coincidan con donde creaste las pantallas
import com.example.marketplace.screens.* import com.example.marketplace.ui.theme.MarketPlaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketPlaceTheme {
                // LLAMAMOS A UNA FUNCIÓN COMPOSABLE (Arregla el error de "Composable invocations")
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // El Scaffold nos da la estructura base
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") { LoginScreen { navController.navigate("home") } }
            composable("home") { HomeScreen { navController.navigate("detail") } }
            composable("detail") { DetailScreen { navController.popBackStack() } }
            composable("favs") { FavoritesScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}