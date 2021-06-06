package com.code.jumia.util.extention

import com.code.jumia.util.parsing.ParsingHelper
import java.lang.reflect.Type

fun <T> String.convertToModel(type: Type): T {
    return ParsingHelper.getGson().fromJson<T>(this, type)
}


