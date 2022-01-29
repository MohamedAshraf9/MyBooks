package com.megahed.mybooks.feature_data.data.data_source.dao

import androidx.room.*
import com.megahed.mybooks.feature_data.domain.models.Document
import kotlinx.coroutines.flow.Flow

@Dao
interface DocumentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDocument(document: Document)

    @Update
    suspend fun update(document: Document)

    @Delete
    suspend fun deleteDocument(document: Document)

    @Query("SELECT * FROM document")
    fun getDocument(): Flow<List<Document>>

    @Query("SELECT * FROM document WHERE docId = :id")
    suspend fun getDocumentById(id: Int): Document?


    @Query("DELETE FROM document")
    fun deleteAllDocument()


}