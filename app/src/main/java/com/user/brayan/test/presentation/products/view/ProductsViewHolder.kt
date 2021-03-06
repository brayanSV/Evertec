package com.user.brayan.test.presentation.products.view

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.user.brayan.test.R
import com.user.brayan.test.presentation.products.model.ProductsModel
import java.text.NumberFormat
import java.util.*

class ProductsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    fun bind(item: ProductsModel) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvPrecio: TextView = view.findViewById(R.id.tvPrecio)
        val tvCantidad: TextView = view.findViewById(R.id.tvCantidad)
        val photoProd: ImageView = view.findViewById(R.id.photoProd)
        val btnSubtract: Button = view.findViewById(R.id.btnSubtract)
        val btnAddProduct: Button = view.findViewById(R.id.btnAddProduct)

        val pesosCol = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        pesosCol.maximumFractionDigits = 0

        Picasso.get().load(item.photo).into(photoProd)
        tvTitle.text = "${item.title}"
        tvPrecio.text = "${pesosCol.format(item.price)}"

        btnSubtract.setOnClickListener {
            tvCantidad.text = "${subtractProduct(Integer.parseInt(tvCantidad.text.toString()))}"
        }

        btnAddProduct.setOnClickListener {
            tvCantidad.text = "${addProduct(Integer.parseInt(tvCantidad.text.toString()))}"
        }
    }

    fun addProduct(cant: Int): Int {
        return cant+1
    }

    fun subtractProduct(cant: Int): Int {
        return if (cant == 0) 0 else (cant-1)
    }
}