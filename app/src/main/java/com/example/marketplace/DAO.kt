package com.example.marketplace

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<FavoriteProduct>>

    annotation class FavoriteProduct

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(product: FavoriteProduct)
}