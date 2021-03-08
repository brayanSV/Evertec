package com.user.brayan.test.presentation.products.view

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.user.brayan.test.R
import com.user.brayan.test.data.db.ApplicationDatabase
import com.user.brayan.test.data.db.dao.model.CartEntity
import com.user.brayan.test.presentation.UserSingleton
import com.user.brayan.test.presentation.products.model.ProductsViewModel
import com.user.brayan.test.tools.FormatMoney

class ProductsViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    var accountId: Long = 0

    fun bind(item: ProductsViewModel) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvPrecio: TextView = view.findViewById(R.id.tvPrecio)
        val tvCantidad: TextView = view.findViewById(R.id.tvAmount)
        val photoProd: ImageView = view.findViewById(R.id.photoProd)
        val btnSubtract: Button = view.findViewById(R.id.btnSubtract)
        val btnAddProduct: Button = view.findViewById(R.id.btnAddProduct)

        Picasso.get().load(item.photo).into(photoProd)
        tvTitle.text = "${item.title}"
        tvPrecio.text = "${FormatMoney().FormatCol(item.price)}"
        tvCantidad.text = "${item.cant}"

        accountId = UserSingleton.getInstance().onlineUser(view.context).accountId

        btnSubtract.setOnClickListener {
            val cant: Int = Integer.parseInt(tvCantidad.text.toString())
            tvCantidad.text = "${subtractProduct(cant, item.product_id)}"
        }

        btnAddProduct.setOnClickListener {
            val cant: Int = Integer.parseInt(tvCantidad.text.toString())
            tvCantidad.text = "${addProduct(cant, item.product_id)}"
        }
    }

    private fun addProduct(cant: Int, productId: Long): Int {
        val newCant = cant+1
        val productCart = ApplicationDatabase.getAppDataBase(view.context)?.getCartDao()?.findByProduct(productId, accountId)

        if (productCart != null) {
            ApplicationDatabase.getAppDataBase(view.context)?.getCartDao()?.updateCantProduct(newCant, productId, accountId)
        } else {
            ApplicationDatabase.getAppDataBase(view.context)?.getCartDao()?.saveProducts(
                CartEntity(
                    productId = productId,
                    cant = newCant,
                    accountId = accountId
                )
            )
        }

        return newCant
    }

    private fun subtractProduct(cant: Int, productId: Long): Int {
        val newCant = if (cant == 0) 0 else (cant-1)
        val productCart = ApplicationDatabase.getAppDataBase(view.context)?.getCartDao()?.findByProduct(productId, accountId)

        if (cant == 0 && productCart != null) {
            ApplicationDatabase.getAppDataBase(view.context)?.getCartDao()?.deletefindByProduct(productId, accountId)
        } else {
            ApplicationDatabase.getAppDataBase(view.context)?.getCartDao()?.updateCantProduct(newCant, productId, accountId)
        }

        return if (cant == 0) 0 else (cant-1)
    }
}