package com.user.brayan.test.presentation.products.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseFragment
import com.user.brayan.test.domain.interactor.products.ProductsInteractorImp
import com.user.brayan.test.presentation.products.ProductsContract
import com.user.brayan.test.presentation.products.model.ProductsModel
import com.user.brayan.test.presentation.products.presenter.ProductsPresenter
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : BaseFragment(), ProductsContract.View {
    lateinit var presenter: ProductsPresenter
    private val productsAdapter = ProductsAdapter()

    override fun getLayout(): Int {
        return R.layout.fragment_products
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ProductsPresenter(ProductsInteractorImp())
        presenter.attachView(this)
        presenter.loadProducts()
    }

    override fun loadProducts(productsList: List<ProductsModel>) {
        rcvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        rcvProducts.adapter = productsAdapter
        productsAdapter.setData(productsList)
    }

    override fun showError(msgError: String) {
        showToast(requireContext(), msgError)
    }
}