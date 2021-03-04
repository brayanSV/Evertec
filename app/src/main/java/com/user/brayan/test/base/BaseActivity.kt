package com.user.brayan.test.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(getLayout())
    }

    abstract fun getLayout(): Int

    fun showToast(context: Context, msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}