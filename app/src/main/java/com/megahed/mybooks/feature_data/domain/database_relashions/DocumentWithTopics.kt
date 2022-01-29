package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.domain.models.Topic

//Many to Many Relation
data class DocumentWithTopics(
    @Embedded val document: Document,
    @Relation(
        parentColumn = "docId",
        entityColumn = "topicId",
        associateBy = Junction(DocumentWithTopics::class)
    )
    val topics: List<Topic>
)
