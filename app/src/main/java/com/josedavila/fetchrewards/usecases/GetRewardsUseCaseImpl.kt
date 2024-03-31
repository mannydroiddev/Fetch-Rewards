package com.josedavila.fetchrewards.usecases

import com.josedavila.fetchrewards.datasources.db.RewardDao
import com.josedavila.fetchrewards.datasources.remote.RewardApi
import com.josedavila.fetchrewards.mappers.RewardApiResponseMapper
import com.josedavila.fetchrewards.models.Reward
import javax.inject.Inject

internal class GetRewardsUseCaseImpl @Inject constructor(
    private val rewardDao: RewardDao,
    private val rewardApi: RewardApi,
    private val rewardApiResponseMapper: RewardApiResponseMapper,
) : GetRewardsUseCase {

    override suspend fun invoke(): List<Reward> {
        val response = rewardApi.getRewards()
        val rewards = rewardApiResponseMapper.mapFromResponse(response)
        rewardDao.insertRewards(rewards)
        return rewardDao.getAllRewards()
    }
}
