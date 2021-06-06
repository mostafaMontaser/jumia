package com.code.jumia.repository.remote.login


import com.code.jumia.model.request.BaseRequestFactory
import com.code.jumia.model.response.login.Country
import com.code.jumia.model.response.login.CountryResponse
import com.code.jumia.model.retrofit.Api
import com.code.jumia.model.retrofit.Service
import com.code.jumia.repository.remote.BaseRemoteRepo
import retrofit2.Response

class LoginRemoteRepo(var api:Api) : BaseRemoteRepo() {
    override suspend fun fetchData(requestFactory: BaseRequestFactory): Response<CountryResponse>? {
        return api.getCountries(requestFactory.getUrl())
    }
}