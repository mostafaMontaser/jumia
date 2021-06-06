package com.code.jumia.model.request.login


import com.code.jumia.model.request.BaseRequestFactory
import com.code.jumia.model.request.BaseRequestParam
import com.code.jumia.model.retrofit.EndPoints


class LoginRequestFactory() :
    BaseRequestFactory() {
    override fun getEndPoint(): String = EndPoints.TEST
    override fun getRequestParam(): BaseRequestParam = BaseRequestParam()
}