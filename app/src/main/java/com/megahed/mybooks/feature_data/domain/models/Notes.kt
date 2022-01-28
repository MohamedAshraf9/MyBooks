package com.megahed.mybooks.feature_data.domain.models

import androidx.room.PrimaryKey
import com.megahed.mybooks.helper.DocumentType

data class Notes(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val title:String,
    val content:String,
    val color:Int,
    val time:Long
)
