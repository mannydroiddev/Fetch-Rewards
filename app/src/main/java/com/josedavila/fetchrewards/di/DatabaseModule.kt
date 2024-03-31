package com.josedavila.fetchrewards.di

import android.content.Context
import androidx.room.Room
import com.josedavila.fetchrewards.datasources.db.RewardsDatabase
import com.josedavila.fetchrewards.datasources.db.RewardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun provideRewardsDatabase(@ApplicationContext context: Context): RewardsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            RewardsDatabase::class.java,
            "rewards_database"
        ).build()
    }

    @Provides
    fun provideRewardDao(database: RewardsDatabase): RewardDao {
        return database.rewardDao()
    }
}
