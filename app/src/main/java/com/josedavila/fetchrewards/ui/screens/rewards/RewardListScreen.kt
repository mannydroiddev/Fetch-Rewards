package com.josedavila.fetchrewards.ui.screens.rewards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.josedavila.fetchrewards.R
import com.josedavila.fetchrewards.ui.components.RewardList
import com.josedavila.fetchrewards.ui.components.SystemError
import com.josedavila.fetchrewards.ui.theme.paddingXLarge

@Composable
internal fun RewardListScreen(
    viewModel: RewardsListViewModel = hiltViewModel()
) {
    val isLoadingState = viewModel.isLoading.collectAsState(initial = true)
    val isErrorState = viewModel.isError.collectAsState(initial = false)
    val rewardListState = viewModel.filteredRewardList.collectAsState(initial = emptyList())
    val groupIdListState = viewModel.groupIdList.collectAsState(initial = emptyList())
    val articlesLazyListState = rememberLazyListState()

    if (isLoadingState.value) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else if (isErrorState.value) {
        SystemError()
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
        ) {
            val rewardList = rewardListState.value
            if (rewardList.isNotEmpty()) {
                RewardList(
                    rewardsList = rewardListState.value,
                    groupIdList = groupIdListState.value,
                    lazyListState = articlesLazyListState,
                )
            } else {
                Spacer(Modifier.height(paddingXLarge))
                Text(
                    text = stringResource(id = R.string.no_rewards_found),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}
