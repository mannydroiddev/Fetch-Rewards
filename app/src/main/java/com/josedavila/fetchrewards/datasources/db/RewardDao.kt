package com.josedavila.fetchrewards.datasources.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.josedavila.fetchrewards.models.Reward

@Dao
internal interface RewardDao {
    @Query("SELECT * FROM rewards")
    fun getAllRewards(): List<Reward>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRewards(rewards: List<Reward>)
}
