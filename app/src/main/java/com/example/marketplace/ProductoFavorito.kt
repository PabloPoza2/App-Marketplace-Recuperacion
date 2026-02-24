package com.example.marketplace

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class ProductoFavorito(
    @PrimaryKey val id: Int,
    val title: String
)