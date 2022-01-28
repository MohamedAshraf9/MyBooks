package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.TopicDao
import com.megahed.mybooks.feature_data.domain.models.Topic
import com.megahed.mybooks.feature_data.domain.repository.TopicRepository
import kotlinx.coroutines.flow.Flow

class TopicRepositoryImpl(
    private val topicDao: TopicDao
) : TopicRepository {
    override suspend fun insertTopic(topic: Topic) {
        TODO("Not yet implemented")
    }

    override suspend fun update(topic: Topic) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTopic(topic: Topic) {
        TODO("Not yet implemented")
    }

    override fun getTopic(): Flow<List<Topic>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopicById(id: Int): Topic? {
        TODO("Not yet implemented")
    }

    override fun deleteAllTopic() {
        TODO("Not yet implemented")
    }
}