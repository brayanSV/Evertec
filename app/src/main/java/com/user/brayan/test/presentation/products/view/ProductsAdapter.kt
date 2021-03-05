package com.user.brayan.test.presentation.products.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.user.brayan.test.R
import com.user.brayan.test.presentation.products.model.ProductsModel

class ProductsAdapter: RecyclerView.Adapter<ProductsViewHolder>() {
    private lateinit var productsList: List<ProductsModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder = ProductsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.products, parent, false)
    )

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) = holder.bind(productsList[position])
    override fun getItemCount(): Int = productsList.size

    fun setData(productsList: List<ProductsModel>) {
        this.productsList = productsList
        notifyDataSetChanged()
    }
}