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
    primaryKeys = ["docIdParent", "docIdChild"],
    foreignKeys = [
        ForeignKey(entity = Document::class,
            parentColumns = ["docId"],
            childColumns = ["docIdParent"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
        ForeignKey(entity = Document::class,
            parentColumns = ["docId"],
            childColumns = ["docIdChild"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )

    ]
)
data class DocumentsCrossRef(
    val docIdParent: Long,
    val docIdChild: Long
)
