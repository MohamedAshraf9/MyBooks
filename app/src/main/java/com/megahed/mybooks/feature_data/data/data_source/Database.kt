package com.megahed.mybooks.feature_data.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.megahed.mybooks.feature_data.data.data_source.dao.CategoryDao
import com.megahed.mybooks.feature_data.data.data_source.dao.DocumentDao
import com.megahed.mybooks.feature_data.data.data_source.dao.NoteDao
import com.megahed.mybooks.feature_data.data.data_source.dao.TopicDao
import com.megahed.mybooks.feature_data.domain.database_relashions.DocumentCategoryCrossRef
import com.megahed.mybooks.feature_data.domain.database_relashions.DocumentTopicCrossRef
import com.megahed.mybooks.feature_data.domain.database_relashions.DocumentsCrossRef
import com.megahed.mybooks.feature_data.domain.models.*

@Database(
    entities = [
        Document::class,
        Topic::class,
        Notes::class,
        Category::class,
        TimeReading::class,
        DocumentCategoryCrossRef::class,
        DocumentsCrossRef::class,
        DocumentTopicCrossRef::class
               ],
    version = 1
)
abstract class Database :RoomDatabase() {

    companion object{
        const val DATABASE_NAME="myBooks"
    }

    abstract val documentDao:DocumentDao
    abstract val noteDao:NoteDao
    abstract val topicDao:TopicDao
    abstract val categoryDao:CategoryDao


}