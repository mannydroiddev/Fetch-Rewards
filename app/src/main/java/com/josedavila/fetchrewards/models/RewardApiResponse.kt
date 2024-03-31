package com.josedavila.fetchrewards.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.math.BigDecimal

@JsonClass(generateAdapter = true)
internal data class RewardApiResponse(
    @Json(name = "id")
    val id: BigDecimal,
    @Json(name = "listId")
    val listId: BigDecimal,
    @Json(name = "name")
    val name: String?,
)
