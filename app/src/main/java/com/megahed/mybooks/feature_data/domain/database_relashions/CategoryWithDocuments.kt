package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Category
import com.megahed.mybooks.feature_data.domain.models.Document

data class CategoryWithDocuments(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "catId",
        entityColumn = "docId",
        associateBy = Junction(DocumentCategoryCrossRef::class)
    )
    val documents: List<Document>
)
