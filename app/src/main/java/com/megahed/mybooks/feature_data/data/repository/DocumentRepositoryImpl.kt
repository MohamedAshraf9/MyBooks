package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.DocumentDao
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow

class DocumentRepositoryImpl(
    private val documentDao: DocumentDao
) :DocumentRepository {
    override suspend fun insertDocument(document: Document) {
        TODO("Not yet implemented")
    }

    override suspend fun update(document: Document) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDocument(document: Document) {
        TODO("Not yet implemented")
    }

    override fun getDocument(): Flow<List<Document>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDocumentById(id: Int): Document? {
        TODO("Not yet implemented")
    }

    override fun deleteAllDocument() {
        TODO("Not yet implemented")
    }
}