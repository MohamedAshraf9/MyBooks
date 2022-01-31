package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.TopicDao
import com.megahed.mybooks.feature_data.domain.models.Topic
import com.megahed.mybooks.feature_data.domain.repository.TopicRepository
import kotlinx.coroutines.flow.Flow

class TopicRepositoryImpl(
    private val topicDao: TopicDao
) : TopicRepository {
    override suspend fun insertTopic(topic: Topic) {
        topicDao.insertTopic(topic)
    }

    override suspend fun update(topic: Topic) {
        topicDao.update(topic)
    }

    override suspend fun deleteTopic(topic: Topic) {
        topicDao.deleteTopic(topic)
    }

    override fun getTopics(): Flow<List<Topic>> {
       return topicDao.getTopics()
    }

    override suspend fun getTopicById(id: Int): Topic? {
      return  topicDao.getTopicById(id)
    }

    override fun deleteAllTopic() {
        topicDao.deleteAllTopic()
    }
}