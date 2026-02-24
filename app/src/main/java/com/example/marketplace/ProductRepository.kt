package com.example.marketplace

class ProductRepository(private val apiService: ApiService) {

    suspend fun getProductsFromApi(): List<Product> {
        return apiService.getProducts()
    }
}