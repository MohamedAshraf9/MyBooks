package com.megahed.mybooks.feature_data.data.repository

import com.megahed.mybooks.feature_data.data.data_source.dao.NoteDao
import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) :NoteRepository {
    override suspend fun insertNote(note: Notes) {
        noteDao.insertNote(note)
    }

    override suspend fun update(note: Notes) {
        noteDao.update(note)
    }

    override suspend fun deleteNote(note: Notes) {
        noteDao.deleteNote(note)
    }

    override fun getNotes(): Flow<List<Notes>> {
       return noteDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Notes? {
       return noteDao.getNoteById(id)
    }

    override fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }
}