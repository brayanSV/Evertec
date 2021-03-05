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

        //val pesosCol = DecimalFormat("#,###.##")
        val pesosCol = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        pesosCol.maximumFractionDigits = 0

        Picasso.get().load(item.photo).into(photoProd)
        tvTitle.text = "${item.title}"
        tvPrecio.text = "${pesosCol.format(item.price)}"
    }
}