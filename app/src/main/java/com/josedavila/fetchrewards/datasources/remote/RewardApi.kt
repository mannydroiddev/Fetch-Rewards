package com.josedavila.fetchrewards.datasources.remote

import com.josedavila.fetchrewards.models.RewardApiResponse
import retrofit2.http.GET

internal interface RewardApi {

    @GET("hiring.json")
    suspend fun getRewards(): List<RewardApiResponse>
}
