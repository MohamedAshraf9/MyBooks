package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Topic(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val topicName:String,
)
