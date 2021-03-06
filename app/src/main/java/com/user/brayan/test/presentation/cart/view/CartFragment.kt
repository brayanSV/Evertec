package com.user.brayan.test.presentation.cart.view

import android.os.Bundle
import android.view.View
import android.widget.SimpleAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseFragment
import com.user.brayan.test.domain.interactor.cart.ProductsCartInteractorImp
import com.user.brayan.test.presentation.cart.CartContract
import com.user.brayan.test.presentation.cart.model.CartModel
import com.user.brayan.test.presentation.cart.presenter.CartPresenter
import kotlinx.android.synthetic.main.fragment_cart.*
import java.util.*

class CartFragment : BaseFragment(), CartContract.View {
    lateinit var presenter: CartPresenter
    private var productsCartAdapter = ProductsCartAdapter()

    override fun getLayout(): Int {
        return R.layout.fragment_cart
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = CartPresenter(ProductsCartInteractorImp())
        presenter.attachView(this)
        presenter.loadProducts()
    }

    override fun showProductsCart() {
        rcvProductsCart.visibility = View.VISIBLE
    }

    override fun hideProductsCart() {
        rcvProductsCart.visibility = View.GONE
    }

    override fun loadProductsCart(productsList: List<CartModel>) {
        rcvProductsCart.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rcvProductsCart.adapter = productsCartAdapter
        productsCartAdapter.setData(productsList)

        val swipeHandler = object : SwipeToDeleteCart(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rcvProductsCart.adapter as ProductsCartAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rcvProductsCart)
    }

    override fun showError(msgError: String) {
        showError(msgError)
    }
}