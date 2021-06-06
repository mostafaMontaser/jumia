package com.code.jumia.repository.local

import com.code.jumia.model.response.CacheEntry
import com.code.jumia.util.extention.convertToModel
import com.code.jumia.util.parsing.ParsingHelper
import com.ibm.jazzcash.repository.local.SecureSharedPref
import java.lang.reflect.Type
import java.util.*

open class BaseLocalRepo {
    open fun getCashedObject(type: Type): Any? {
        val entry: CacheEntry<Any>? = SecureSharedPref.getObject(type)
        val cachedObject: Any? = entry?.obj
        return if (cachedObject != null) {
            val cachedObject: Any? =
                ParsingHelper.getGson().toJson(cachedObject).convertToModel(type)
            cachedObject
        } else null
    }
    fun <T> saveObject(instance: T, type: Type, lastModifiedDate: Long = Date().time) =
        SecureSharedPref.edit().putObject(CacheEntry(instance, lastModifiedDate), type).apply()

}