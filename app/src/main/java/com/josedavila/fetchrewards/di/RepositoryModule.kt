package com.josedavila.fetchrewards.di

import com.josedavila.fetchrewards.repositories.RewardRepository
import com.josedavila.fetchrewards.repositories.RewardRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindRewardRepository(repository: RewardRepositoryImpl): RewardRepository
}
