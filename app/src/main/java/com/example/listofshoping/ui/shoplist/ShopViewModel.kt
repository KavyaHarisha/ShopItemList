package com.example.listofshoping.ui.shoplist

import androidx.lifecycle.ViewModel
import com.example.listofshoping.data.db.entities.ShopItem
import com.example.listofshoping.data.repositories.ShopRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ShopViewModel(val shopRepository: ShopRepository): ViewModel() {

    fun upsert(item: ShopItem) = CoroutineScope(Dispatchers.Main).launch {
        shopRepository.upsert(item)
    }

    fun delete(item: ShopItem) = CoroutineScope(Dispatchers.Main).launch {
        shopRepository.delete(item)
    }

    fun getAllShopItems() = shopRepository.getShopItems()
}