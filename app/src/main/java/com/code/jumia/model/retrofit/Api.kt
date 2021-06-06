package com.code.jumia.model.retrofit

import com.code.jumia.model.response.login.CountryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    suspend fun getCountries(@Url url: String): Response<CountryResponse>?
}