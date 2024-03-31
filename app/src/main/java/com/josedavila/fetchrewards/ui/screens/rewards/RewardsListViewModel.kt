package com.josedavila.fetchrewards.ui.screens.rewards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josedavila.fetchrewards.models.NetworkState
import com.josedavila.fetchrewards.models.Reward
import com.josedavila.fetchrewards.repositories.RewardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
internal class RewardsListViewModel @Inject constructor(
    private val rewardRepository: RewardRepository,
) : ViewModel() {

    private val rewardListState = rewardRepository.rewardListState
    private val rewardList = rewardListState.map { state ->
        (state as? NetworkState.Success)?.data ?: emptyList()
    }

    private val _filteredRewardList = rewardList.map { list ->
        list.filter { reward ->
            reward.name.isNotEmpty()
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    internal val filteredRewardList: StateFlow<List<Reward>> = _filteredRewardList

    private val _groupIdList = _filteredRewardList.map { list ->
        getSortedGroupIdList(list)
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    internal val groupIdList: StateFlow<List<BigDecimal>> = _groupIdList

    private val _isLoading = rewardListState.map {
        it is NetworkState.Loading
    }.stateIn(viewModelScope, SharingStarted.Lazily, initialValue = true)
    internal val isLoading: StateFlow<Boolean> = _isLoading

    private val _isError = rewardListState.map {
        it is NetworkState.Error
    }.stateIn(viewModelScope, SharingStarted.Lazily, initialValue = false)
    internal val isError: StateFlow<Boolean> = _isError

    init {
        fetchRewards()
    }

    fun fetchRewards() {
        viewModelScope.launch(Dispatchers.IO) {
            rewardRepository.getRewards()
        }
    }

    private fun getSortedGroupIdList(filteredRewards: List<Reward>) : List<BigDecimal> {
        val idCollection = filteredRewards.asSequence().map { it.listId }.distinct()
        return idCollection.sorted().toList()
    }
}
