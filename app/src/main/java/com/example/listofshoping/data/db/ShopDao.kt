package com.example.listofshoping.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.listofshoping.data.db.entities.ShopItem

@Dao
interface ShopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upinsert(item: ShopItem)

    @Delete
    suspend fun delete(item: ShopItem)

    @Query("SELECT * from shoped_item")
    fun getAllShopItems(): LiveData<List<ShopItem>>
}