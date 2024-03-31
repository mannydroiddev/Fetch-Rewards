package com.josedavila.fetchrewards.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.josedavila.fetchrewards.ui.theme.paddingLarge
import java.math.BigDecimal

@Composable
internal fun RewardGroupHeader(groupId: BigDecimal) {
    Text(
        text = "Group ID: $groupId",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingLarge)
    )
}
