package com.josedavila.fetchrewards.repositories

import com.josedavila.fetchrewards.models.NetworkState
import com.josedavila.fetchrewards.models.Reward
import kotlinx.coroutines.flow.StateFlow

internal interface RewardRepository {

    val rewardListState: StateFlow<NetworkState<List<Reward>>>

    fun getRewards()
}
