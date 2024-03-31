package com.josedavila.fetchrewards.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.josedavila.fetchrewards.models.Reward
import java.math.BigDecimal

@Composable
internal fun RewardList(
    rewardsList: List<Reward>,
    groupIdList: List<BigDecimal>,
    lazyListState: LazyListState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier, state = lazyListState) {
        groupIdList.forEach { groupId ->
            item {
                RewardGroupHeader(groupId = groupId)
            }

            val groupRewardList = rewardsList.filter { it.listId == groupId }
            items(items = groupRewardList, key = { it.id }) { reward ->
                RewardListItem(reward)
            }
        }
    }
}
