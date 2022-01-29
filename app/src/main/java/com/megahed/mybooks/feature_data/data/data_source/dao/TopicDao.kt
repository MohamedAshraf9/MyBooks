package com.megahed.mybooks.feature_data.data.data_source.dao

import androidx.room.*
import com.megahed.mybooks.feature_data.domain.models.Topic
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTopic(topic: Topic)

    @Update
    suspend fun update(topic: Topic)

    @Delete
    suspend fun deleteTopic(topic: Topic)

    @Query("SELECT * FROM topic")
    fun getTopic(): Flow<List<Topic>>

    @Query("SELECT * FROM topic WHERE topicId = :id")
    suspend fun getTopicById(id: Int): Topic?


    @Query("DELETE FROM topic")
    fun deleteAllTopic()

}