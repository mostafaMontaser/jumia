package com.code.jumia.dispatcher

import com.code.jumia.model.request.BaseRequestFactory
import com.code.jumia.model.response.ResponseException
import com.code.jumia.repository.local.BaseLocalRepo
import com.code.jumia.repository.remote.BaseRemoteRepo
import com.code.jumia.util.network.NetworkUtil
import java.lang.reflect.Type
import java.util.*

abstract class BaseDispatcher(
    private val localRepo: BaseLocalRepo,
    private val remoteRepo: BaseRemoteRepo
) {
    suspend fun fetchData(cash: Boolean, type: Type, requestFactory: BaseRequestFactory): Any? {
        var errorMessage: String? = null
        var responseCode: String? = null
        val response = try {
            val isNetworkConnected = NetworkUtil.isNetworkAvailable()
            if (isNetworkConnected) {
                remoteRepo.fetchData(requestFactory)
            } else {
                errorMessage = "Check your internet connection"
                responseCode = "NIC"
                null
            }
        } catch (ex: Exception) {
            errorMessage = "Client Error"
            responseCode = ""
            ex.printStackTrace()
            null
        }

        if (response != null) {
            if (response.isSuccessful) {
                val cache = response.body()
                if (cash) {
                    localRepo.saveObject(cache, type)
                }
                return cache
            } else {
                errorMessage = response.errorBody()?.toString()
                responseCode = "" + response.code()
            }
        } else if (cash) {
            val cashed = localRepo.getCashedObject(type)
            if (cashed != null)
                return cashed
        }
        throw ResponseException(
            message = errorMessage,
            responseCode = responseCode,
            endPoint = requestFactory.getEndPoint()
        )
    }

    fun getCashedObject(type: Type): Any? = localRepo.getCashedObject(type)


    fun saveObject(instance: Any?, type: Type, lastModifiedDate: Long = Date().time) =
        localRepo.saveObject(instance, type, lastModifiedDate)
}
