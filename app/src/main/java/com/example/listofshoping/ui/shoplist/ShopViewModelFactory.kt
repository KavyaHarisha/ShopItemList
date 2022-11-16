package com.example.listofshoping.ui.shoplist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listofshoping.data.repositories.ShopRepository

@Suppress("UNCHECKED_CAST")
class ShopViewModelFactory(
    val repository: ShopRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopViewModel(repository) as T
    }
}