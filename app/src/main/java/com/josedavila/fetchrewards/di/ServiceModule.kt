package com.josedavila.fetchrewards.di

import com.josedavila.fetchrewards.datasources.remote.RewardApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
internal class ServiceModule {

    @Provides
    fun provideRewardApi(
        retrofit: Retrofit
    ): RewardApi {
        return retrofit.create(RewardApi::class.java)
    }

    @Provides
    fun provideCoroutineScope() = CoroutineScope(SupervisorJob())
}
