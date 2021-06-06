package com.code.jumia

import android.app.Application
import android.content.Context

class JumiaApplication : Application() {
    companion object {
        private var context: Context? = null
        fun getContext() = context
    }
    private lateinit var initializer:Initializer

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initializer=Initializer(this)
        initializer.initKoin()
    }
}

