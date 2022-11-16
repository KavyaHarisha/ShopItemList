package com.example.listofshoping.ui.shoplist

import com.example.listofshoping.data.db.entities.ShopItem

interface AddDialogListener {
    fun onAddButtonClick(item:ShopItem)
}