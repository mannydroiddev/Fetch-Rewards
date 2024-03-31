package com.josedavila.fetchrewards.mappers

import com.josedavila.fetchrewards.models.Reward
import com.josedavila.fetchrewards.models.RewardApiResponse
import javax.inject.Inject

internal class RewardApiResponseMapper @Inject constructor() :
    ResponseMapper<List<RewardApiResponse>, List<Reward>> {

    override fun mapFromResponse(response: List<RewardApiResponse>): List<Reward> {
        return response.map {
            Reward(
                id = it.id,
                listId = it.listId,
                name = it.name ?: "",
            )
        }
    }
}
