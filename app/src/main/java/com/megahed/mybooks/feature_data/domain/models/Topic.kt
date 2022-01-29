package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Topic(
    @PrimaryKey(autoGenerate = true) val topicId:Long,
    val topicName:String,
)
