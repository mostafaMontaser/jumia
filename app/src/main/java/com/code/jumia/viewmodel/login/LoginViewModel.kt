package com.code.jumia.viewmodel.login

import androidx.lifecycle.MutableLiveData
import com.code.jumia.dispatcher.BaseDispatcher
import com.code.jumia.dispatcher.login.LoginDispatcher
import com.code.jumia.model.request.login.LoginRequestFactory
import com.code.jumia.model.response.login.Country
import com.code.jumia.model.response.login.CountryResponse
import com.code.jumia.viewmodel.BaseViewModel
import com.google.gson.reflect.TypeToken


class LoginViewModel(private val loginDispatcher:LoginDispatcher) : BaseViewModel() {
    val countries = MutableLiveData<List<*>>()


    fun getCountries() {
        fetchData(
            true,
            CountryResponse::class.java,
            LoginRequestFactory(),
            handleCountriesResponse
        )

    }

    private val handleCountriesResponse = { response: Any? ->
        if (response is CountryResponse ) {
            countries.value = response.results
        }
    }

    override fun getDispatcher(): BaseDispatcher {
        return loginDispatcher
    }

}