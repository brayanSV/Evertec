package com.user.brayan.test.presentation.products.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseFragment
import com.user.brayan.test.data.db.ApplicationDatabase
import com.user.brayan.test.data.db.dao.model.ProductsEntity
import com.user.brayan.test.domain.interactor.products.ProductsInteractorImp
import com.user.brayan.test.presentation.UserSingleton
import com.user.brayan.test.presentation.products.ProductsContract
import com.user.brayan.test.presentation.products.presenter.ProductsPresenter
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : BaseFragment(), ProductsContract.View {
    private var accountId: Long = 0
    lateinit var presenter: ProductsPresenter
    private val productsAdapter = ProductsAdapter()

    override fun getLayout(): Int {
        return R.layout.fragment_products
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        accountId = UserSingleton.getInstance().onlineUser(requireContext()).accountId

        presenter = ProductsPresenter(ProductsInteractorImp())
        presenter.attachView(this)
        presenter.loadProducts()
    }

    override fun loadProducts() {
        val products = ApplicationDatabase.getAppDataBase(requireContext())?.getProductsDao()?.getAll(accountId)

        rcvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        rcvProducts.adapter = productsAdapter

        if (products != null) {
            productsAdapter.setData(products)
        }
    }

    override fun saveProducts(products: List<ProductsEntity>) {
        ApplicationDatabase.getAppDataBase((requireContext()))?.getProductsDao()?.saveProducts(products)
    }

    override fun veryfiEmptyProducts(): Boolean {
        val products = ApplicationDatabase.getAppDataBase(requireContext())?.getProductsDao()?.getAll(accountId)
        return products?.isEmpty()!!
    }

    override fun showError(msgError: String) {
        showToast(requireContext(), msgError)
    }
}