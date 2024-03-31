package com.josedavila.fetchrewards.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.josedavila.fetchrewards.ui.screens.rewards.RewardListScreen

@Composable
internal fun RewardsNavHost(
    navHostController: NavHostController,
    modifier: Modifier,
) = NavHost(
    navController = navHostController,
    startDestination = REWARDS_LIST_ROUTE,
    modifier = modifier
) {
    composable(REWARDS_LIST_ROUTE) {
        RewardListScreen()
    }
}
