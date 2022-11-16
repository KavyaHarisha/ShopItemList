package com.example.listofshoping.ui.shoplist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listofshoping.R
import com.example.listofshoping.data.db.ShopDatabase
import com.example.listofshoping.data.db.entities.ShopItem
import com.example.listofshoping.data.repositories.ShopRepository
import com.example.listofshoping.other.ShopItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(),KodeinAware {
    override val kodein by kodein()
    private val factory: ShopViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        /*val db = ShopDatabase(context = this)
        val repository = ShopRepository(db)
        val factory = ShopViewModelFactory(repository = repository)*/
        val viewModel = ViewModelProviders.of(this,factory).get(ShopViewModel::class.java)
        val adapter = ShopItemAdapter(listOf(),viewModel)
        rvShopItems.layoutManager = LinearLayoutManager(this)
        rvShopItems.adapter = adapter
        viewModel.getAllShopItems().observe(this) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
        fab.setOnClickListener {
            AddShopItemDialog(this,object : AddDialogListener{
                override fun onAddButtonClick(item: ShopItem) {
                    viewModel.upsert(item)
                }

            }).show()
        }
    }


}

