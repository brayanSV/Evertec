package com.user.brayan.test.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    abstract fun getLayout(): Int

    fun showToast(context: Context, msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}