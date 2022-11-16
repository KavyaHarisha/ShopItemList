package com.example.listofshoping.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listofshoping.R
import com.example.listofshoping.data.db.entities.ShopItem
import com.example.listofshoping.ui.shoplist.ShopViewModel
import kotlinx.android.synthetic.main.shop_item.view.*

class ShopItemAdapter(
    var items: List<ShopItem>,
    val viewModel: ShopViewModel
): RecyclerView.Adapter<ShopItemAdapter.ShopViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item,parent,false)
        return ShopViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shopItme = items[position]
        holder.itemView.tvName.text = shopItme.name
        holder.itemView.tvAmount.text = "${shopItme.amount}"
        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(shopItme)
        }

        holder.itemView.ivAdd.setOnClickListener {
            shopItme.amount++
            viewModel.upsert(shopItme)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(shopItme.amount>0){
                shopItme.amount--
                viewModel.upsert(shopItme)
            }

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShopViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}