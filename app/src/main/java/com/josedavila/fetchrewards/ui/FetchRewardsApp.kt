package com.josedavila.fetchrewards.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.josedavila.fetchrewards.navigation.RewardsNavHost

@Composable
internal fun FetchRewardsApp(
    navHostController: NavHostController,
) {
    AppContent(navHostController = navHostController)
}

@Composable
internal fun AppContent(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    RewardsNavHost(
        navHostController = navHostController,
        modifier = modifier
    )
}
