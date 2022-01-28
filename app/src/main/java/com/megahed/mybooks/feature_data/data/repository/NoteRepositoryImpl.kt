package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.NoteDao
import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) :NoteRepository {
    override suspend fun insertNote(note: Notes) {
        TODO("Not yet implemented")
    }

    override suspend fun update(note: Notes) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Notes) {
        TODO("Not yet implemented")
    }

    override fun getNotes(): Flow<List<Notes>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteById(id: Int): Notes? {
        TODO("Not yet implemented")
    }

    override fun deleteAllNotes() {
        TODO("Not yet implemented")
    }
}