package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) val catId:Long,
    val categoryName:String,
)
