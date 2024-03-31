package com.josedavila.fetchrewards.converters

import androidx.room.TypeConverter
import java.math.BigDecimal

internal class BigDecimalTypeConverter {
    @TypeConverter
    fun fromBigDecimal(value: BigDecimal?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun toBigDecimal(value: String?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }
}
