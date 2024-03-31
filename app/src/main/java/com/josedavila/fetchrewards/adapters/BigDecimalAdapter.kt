package com.josedavila.fetchrewards.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.ToJson
import okio.IOException
import java.math.BigDecimal

class BigDecimalAdapter {
    @ToJson
    fun toJson(value: BigDecimal): String {
        return value.toString()
    }

    @FromJson
    fun fromJson(reader: JsonReader): BigDecimal {
        return try {
            val string = reader.nextString()
            BigDecimal(string)
        } catch (e: NumberFormatException) {
            throw IOException("Invalid BigDecimal value: ${reader.peekJson()}")
        }
    }
}
