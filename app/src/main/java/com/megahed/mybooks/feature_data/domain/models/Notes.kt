package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.megahed.mybooks.helper.DocumentType
import com.megahed.mybooks.ui.theme.*

@Entity(
    foreignKeys = [
        ForeignKey(entity = Document::class,
            parentColumns = ["docId"],
            childColumns = ["docId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )

    ]
)
data class Notes(
    @PrimaryKey(autoGenerate = true) val id:Long,
    val title:String,
    val content:String,
    val color:Int,
    val time:Long,
    val docId:Long,
    val pageNum:Int?=null
)
{
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
