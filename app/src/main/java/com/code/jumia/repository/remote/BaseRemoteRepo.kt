package com.code.jumia.repository.remote

import com.code.jumia.model.request.BaseRequestFactory
import com.code.jumia.model.response.BaseModel
import retrofit2.Response

abstract class BaseRemoteRepo {
    abstract  suspend fun  fetchData(requestFactory: BaseRequestFactory): Response<out BaseModel>?
}