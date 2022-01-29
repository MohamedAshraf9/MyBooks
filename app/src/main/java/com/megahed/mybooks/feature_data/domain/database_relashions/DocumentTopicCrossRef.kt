package com.megahed.mybooks.feature_data.domain.database_relashions

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Relation
import com.megahed.mybooks.feature_data.domain.models.Category
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.domain.models.Topic

//Many to Many Relation ref
@Entity(
    primaryKeys = ["docId", "topicId"],
    foreignKeys = [
        ForeignKey(entity = Document::class,
            parentColumns = ["docId"],
            childColumns = ["docId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(entity = Topic::class,
            parentColumns = ["topicId"],
            childColumns = ["topicId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )

    ]
)
data class DocumentTopicCrossRef(
    val docId: Long,
    val topicId: Long
)
