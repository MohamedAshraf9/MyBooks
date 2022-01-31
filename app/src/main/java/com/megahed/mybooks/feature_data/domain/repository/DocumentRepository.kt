package com.megahed.mybooks.feature_data.domain.repository

import com.megahed.mybooks.feature_data.domain.models.Document
import kotlinx.coroutines.flow.Flow

interface DocumentRepository {


    suspend fun insertDocument(document: Document)

    suspend fun update(document: Document)

    suspend fun deleteDocument(document: Document)

    fun getDocuments(): Flow<List<Document>>

    suspend fun getDocumentById(id: Int): Document?

    fun deleteAllDocument()

}