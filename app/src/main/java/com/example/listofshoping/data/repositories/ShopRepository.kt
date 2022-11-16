package com.example.listofshoping.data.repositories

import com.example.listofshoping.data.db.ShopDatabase
import com.example.listofshoping.data.db.entities.ShopItem

class ShopRepository(
    val db: ShopDatabase
) {
    suspend fun upsert(item: ShopItem) = db.getShopDao().upinsert(item)
    suspend fun delete(item: ShopItem) = db.getShopDao().delete(item)
    fun getShopItems() = db.getShopDao().getAllShopItems()
}