package com.josedavila.fetchrewards.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "rewards")
internal data class Reward(
    @PrimaryKey
    val id: BigDecimal,
    val listId: BigDecimal,
    val name: String,
)
