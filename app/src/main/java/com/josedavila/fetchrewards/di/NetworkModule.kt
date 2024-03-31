package com.josedavila.fetchrewards.di

import com.josedavila.fetchrewards.adapters.BigDecimalAdapter
import com.josedavila.fetchrewards.utilities.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
internal class NetworkModule {

    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder()
        .add(BigDecimalAdapter())
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    fun providesRetrofit(
        moshi: Moshi,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}
