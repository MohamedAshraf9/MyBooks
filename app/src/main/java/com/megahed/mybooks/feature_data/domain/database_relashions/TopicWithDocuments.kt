package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.domain.models.Topic

data class TopicWithDocuments(
    @Embedded val topic: Topic,
    @Relation(
        parentColumn = "topicId",
        entityColumn = "docId",
        associateBy = Junction(DocumentWithTopics::class)
    )
    val documents: List<Document>
)
