package com.user.brayan.test.presentation.cart.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.brayan.test.R
import com.user.brayan.test.presentation.cart.model.CartModel

class ProductsCartAdapter(): RecyclerView.Adapter<ProductsCartViewHolder>() {
    lateinit var productsList: List<CartModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsCartViewHolder = ProductsCartViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.products_cart, parent, false)
    )

    override fun onBindViewHolder(holder: ProductsCartViewHolder, position: Int) = holder.bind(productsList[position])
    override fun getItemCount(): Int = productsList.size

    fun setData(productsList: List<CartModel>) {
        this.productsList = productsList
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        productsList.drop(position)
        notifyItemRemoved(position)
    }
}