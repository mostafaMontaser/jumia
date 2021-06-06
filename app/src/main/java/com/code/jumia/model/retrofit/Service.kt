package com.code.jumia.model.retrofit

import com.code.jumia.model.request.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    fun getService(): Api =
        Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
}