package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Category
import com.megahed.mybooks.feature_data.domain.models.Document

//Many to Many Relation
data class DocumentWithDocument(
    @Embedded val document: Document,
    @Relation(
        parentColumn = "docId",
        entityColumn = "docId",
        associateBy = Junction(DocumentsCrossRef::class)
    )
    val documents: List<Document>
)
