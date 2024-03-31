package com.josedavila.fetchrewards.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.josedavila.fetchrewards.R
import com.josedavila.fetchrewards.ui.theme.paddingMedium
import com.josedavila.fetchrewards.ui.theme.paddingSmall
import com.josedavila.fetchrewards.ui.theme.paddingXLarge

@Composable
internal fun SystemError() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = paddingSmall, vertical = paddingXLarge
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.system_error),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error)
        )
        Spacer(Modifier.width(paddingMedium))
        Text(
            text = stringResource(id = R.string.system_error),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.error
        )
    }
}
