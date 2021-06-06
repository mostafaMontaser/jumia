package com.code.jumia

import android.content.Context
import com.code.jumia.di.appComponents
import com.code.jumia.di.networkComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Initializer(val context: Context) {
        fun initKoin(){
                startKoin {
                        androidLogger()
                        androidContext(context)
                        modules(
                                appComponents +
                                        networkComponent
                        )
                }
        }
}