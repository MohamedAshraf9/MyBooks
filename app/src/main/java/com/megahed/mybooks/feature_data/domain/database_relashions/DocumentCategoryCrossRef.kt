package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.ForeignKey.SET_NULL
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Category
import com.megahed.mybooks.feature_data.domain.models.Document

//Many to Many Relation ref
@Entity(
    primaryKeys = ["docId", "catId"],
    foreignKeys = [
        ForeignKey(entity = Document::class,
            parentColumns = ["docId"],
            childColumns = ["docId"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
        ForeignKey(entity = Category::class,
            parentColumns = ["catId"],
            childColumns = ["catId"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )

    ]
)
data class DocumentCategoryCrossRef(
    val docId: Long,
    val catId: Long
)
