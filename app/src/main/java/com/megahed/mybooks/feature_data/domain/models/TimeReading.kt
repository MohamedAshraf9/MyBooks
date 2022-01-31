package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
data class TimeReading(
    @PrimaryKey(autoGenerate = true) val timeId:Long,
    val time:Long,
    val docId:Long
)
