package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Category
import com.megahed.mybooks.feature_data.domain.models.Document

//Many to Many Relation
data class DocumentWithCategories(
    @Embedded val document: Document,
    @Relation(
        parentColumn = "docId",
        entityColumn = "catId",
        associateBy = Junction(DocumentCategoryCrossRef::class)
    )
    val categories: List<Category>
)
