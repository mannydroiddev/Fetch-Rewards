package com.josedavila.fetchrewards.di

import com.josedavila.fetchrewards.usecases.GetRewardsUseCase
import com.josedavila.fetchrewards.usecases.GetRewardsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface UseCaseModule {

    @Binds
    fun bingGetRewardsUseCase(useCase: GetRewardsUseCaseImpl): GetRewardsUseCase
}
