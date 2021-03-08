package com.user.brayan.test.presentation.cart.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseFragment
import com.user.brayan.test.data.db.ApplicationDatabase
import com.user.brayan.test.domain.interactor.cart.ProductsCartInteractorImp
import com.user.brayan.test.presentation.UserSingleton
import com.user.brayan.test.presentation.add_cart.view.AddCreditCartActivity
import com.user.brayan.test.presentation.cart.CartContract
import com.user.brayan.test.presentation.cart.presenter.CartPresenter
import com.user.brayan.test.presentation.main.view.MainActivity
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : BaseFragment(), CartContract.View {
    private var accountId: Long = 0
    lateinit var presenter: CartPresenter
    private var productsCartAdapter = ProductsCartAdapter()

    override fun getLayout(): Int {
        return R.layout.fragment_cart
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        accountId = UserSingleton.getInstance().onlineUser(requireContext()).accountId

        presenter = CartPresenter(ProductsCartInteractorImp())
        presenter.attachView(this)
        presenter.loadProducts()

        btnCheckOut.setOnClickListener {
            navigateToAddCard()
        }
    }

    override fun showProductsCart() {
        rcvProductsCart.visibility = View.VISIBLE
    }

    override fun hideProductsCart() {
        rcvProductsCart.visibility = View.GONE
    }

    override fun veryfiEmptyProducts(): Boolean {
        val products = ApplicationDatabase.getAppDataBase(requireContext())?.getCartDao()?.getAll(accountId)
        return products?.isEmpty()!!
    }

    override fun loadProductsCart() {
        val products = ApplicationDatabase.getAppDataBase(requireContext())?.getCartDao()?.getAll(accountId)
        rcvProductsCart.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rcvProductsCart.adapter = productsCartAdapter

        if (products != null) {
            productsCartAdapter.setData(products)
        }

        val swipeHandler = object : SwipeToDeleteCart(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rcvProductsCart.adapter as ProductsCartAdapter
                adapter.removeAt(viewHolder.adapterPosition, requireContext())
                showToast(requireContext(), "Producto eliminado de la cesta")
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rcvProductsCart)
    }

    override fun navigateToAddCard() {
        val intent = Intent(requireContext(), AddCreditCartActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun showError(msgError: String) {
        showError(msgError)
    }
}