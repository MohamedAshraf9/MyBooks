package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.domain.models.Notes

//One to Many Relation
data class DocumentWithNotes(
    @Embedded val document: Document,
    @Relation(
        parentColumn = "docId",
        entityColumn = "docId"
    )
    val notes: List<Notes>
)
