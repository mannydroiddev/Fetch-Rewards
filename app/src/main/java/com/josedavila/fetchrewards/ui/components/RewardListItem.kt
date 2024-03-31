package com.josedavila.fetchrewards.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.josedavila.fetchrewards.R
import com.josedavila.fetchrewards.models.Reward
import com.josedavila.fetchrewards.ui.theme.paddingExtraSmall
import com.josedavila.fetchrewards.ui.theme.paddingLarge
import com.josedavila.fetchrewards.ui.theme.paddingMedium
import com.josedavila.fetchrewards.ui.theme.rewardImageSize
import com.josedavila.fetchrewards.ui.theme.roundedCornerPercent
import com.josedavila.fetchrewards.utilities.FETCH_LOGO

@Composable
internal fun RewardListItem(
    reward: Reward,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .padding(vertical = paddingExtraSmall)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingLarge),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = FETCH_LOGO,
                modifier = modifier
                    .size(rewardImageSize)
                    .clip(RoundedCornerShape(roundedCornerPercent)),
                contentDescription = stringResource(
                    id = R.string.image_content_description,
                    reward.name
                ),
            )
            Spacer(Modifier.width(paddingMedium))
            Text(
                text = reward.name,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
