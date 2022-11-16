package com.example.listofshoping.ui.shoplist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.listofshoping.R
import com.example.listofshoping.data.db.entities.ShopItem
import kotlinx.android.synthetic.main.dialog_add_shop_item.*

class AddShopItemDialog(context: Context,
var dialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shop_item)
        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()
            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please fill all the information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dialogListener.onAddButtonClick(ShopItem(name,amount.toInt()))
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}