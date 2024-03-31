package com.josedavila.fetchrewards.usecases

import com.josedavila.fetchrewards.models.Reward

internal interface GetRewardsUseCase {

    suspend operator fun invoke(): List<Reward>
}
