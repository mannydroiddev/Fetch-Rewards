package com.josedavila.fetchrewards.repositories

import android.util.Log
import com.josedavila.fetchrewards.models.NetworkState
import com.josedavila.fetchrewards.models.Reward
import com.josedavila.fetchrewards.usecases.GetRewardsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class RewardRepositoryImpl @Inject constructor(
    private val getRewardsUseCase: GetRewardsUseCase,
    private val coroutineScope: CoroutineScope,
) : RewardRepository {

    override val rewardListState: MutableStateFlow<NetworkState<List<Reward>>> =
        MutableStateFlow(NetworkState.Uninitialized)

    override fun getRewards() {
        coroutineScope.launch {
            try {
                rewardListState.value = NetworkState.Loading
                val rewardList = getRewardsUseCase.invoke()
                rewardListState.value = NetworkState.Success(rewardList)
                Log.d("Success:", rewardList.toString())
            } catch (exception: Exception) {
                rewardListState.value =
                    NetworkState.Error("Exception encountered: " + exception.message)
                Log.d("Error:", exception.message ?: exception.toString())
            }
        }
    }
}
