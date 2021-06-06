package com.code.jumia.view.util

import com.code.jumia.model.response.ErrorScreen

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(error:ErrorScreen)
}