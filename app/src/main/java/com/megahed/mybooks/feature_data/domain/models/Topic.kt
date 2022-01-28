package com.megahed.mybooks.feature_data.domain.models

import androidx.room.PrimaryKey

data class Topic(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val topicName:String,
)
