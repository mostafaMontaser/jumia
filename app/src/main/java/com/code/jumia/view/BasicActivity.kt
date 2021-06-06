package com.code.jumia.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.code.jumia.model.response.ErrorScreen
import com.code.jumia.view.util.BaseView
import com.code.jumia.viewmodel.BaseViewModel


@SuppressLint("Registered")
abstract class BasicActivity : BaseActivity() ,BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel()?.showFullLoading?.observe(this, showFullLoading)
        getViewModel()?.errorDialog?.observe(this, showErrorUi)
    }

    private val showFullLoading = Observer<Boolean> {
        if (it)
            showLoading()
        else
            hideLoading()
    }

    private val showErrorUi = Observer<ErrorScreen> { showError(it) }

    override fun showError(error: ErrorScreen) {
        Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
    }

    abstract fun getViewModel(): BaseViewModel?
}




