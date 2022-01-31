package com.megahed.mybooks.feature_data.domain.repository

import com.megahed.mybooks.feature_data.domain.models.Topic
import kotlinx.coroutines.flow.Flow

interface TopicRepository {


    suspend fun insertTopic(topic: Topic)

    suspend fun update(topic: Topic)

    suspend fun deleteTopic(topic: Topic)

    fun getTopics(): Flow<List<Topic>>

    suspend fun getTopicById(id: Int): Topic?

    fun deleteAllTopic()

}