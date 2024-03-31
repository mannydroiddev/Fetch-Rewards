package com.josedavila.fetchrewards.datasources.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.josedavila.fetchrewards.converters.BigDecimalTypeConverter
import com.josedavila.fetchrewards.models.Reward

@Database(entities = [Reward::class], version = 1)
@TypeConverters(BigDecimalTypeConverter::class)
internal abstract class RewardsDatabase : RoomDatabase() {
    abstract fun rewardDao(): RewardDao
}
