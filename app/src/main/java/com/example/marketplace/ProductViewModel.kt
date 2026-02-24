package com.example.marketplace

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    var products by mutableStateOf<List<Product>>(emptyList())

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                products = repository.getProductsFromApi()
            } catch (e: Exception) {

            }
        }
    }
}

