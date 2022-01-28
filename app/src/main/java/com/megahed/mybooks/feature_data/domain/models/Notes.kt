package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.megahed.mybooks.helper.DocumentType
import com.megahed.mybooks.ui.theme.*

@Entity
data class Notes(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val title:String,
    val content:String,
    val color:Int,
    val time:Long
)
{
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
