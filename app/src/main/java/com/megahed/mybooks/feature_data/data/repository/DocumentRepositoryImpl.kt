package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.DocumentDao
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow

class DocumentRepositoryImpl(
    private val documentDao: DocumentDao
) :DocumentRepository {
    override suspend fun insertDocument(document: Document) {
        documentDao.insertDocument(document)
    }

    override suspend fun update(document: Document) {
        documentDao.update(document)
    }

    override suspend fun deleteDocument(document: Document) {
        documentDao.deleteDocument(document)
    }

    override fun getDocuments(): Flow<List<Document>> {
        return documentDao.getDocuments()
    }

    override suspend fun getDocumentById(id: Int): Document? {
       return documentDao.getDocumentById(id)
    }

    override fun deleteAllDocument() {
        documentDao.deleteAllDocument()
    }
}