package com.user.brayan.test.presentation.cart.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.brayan.test.R
import com.user.brayan.test.data.db.ApplicationDatabase
import com.user.brayan.test.presentation.cart.model.CartViewModel

class ProductsCartAdapter(): RecyclerView.Adapter<ProductsCartViewHolder>() {
    lateinit var productsList: MutableList<CartViewModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsCartViewHolder = ProductsCartViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.products_cart, parent, false)
    )

    override fun onBindViewHolder(holder: ProductsCartViewHolder, position: Int) = holder.bind(productsList[position])
    override fun getItemCount(): Int = productsList.size

    fun setData(productsList: MutableList<CartViewModel>) {
        this.productsList = productsList
        notifyDataSetChanged()
    }

    fun removeAt(position: Int, context: Context) {
        ApplicationDatabase.getAppDataBase(context)?.getCartDao()?.deletefindByProduct(productsList[position].cartId)
        productsList.removeAt(position)
        notifyItemRemoved(position)
    }
}