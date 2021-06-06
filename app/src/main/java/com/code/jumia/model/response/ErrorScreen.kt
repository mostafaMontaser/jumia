package com.code.jumia.model.response

data class ErrorScreen(val title: String, val message: String?, val renderType: String) {
    constructor(message: String?) : this("", message, "")
}