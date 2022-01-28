package com.megahed.mybooks.feature_data.domain.repository

import com.megahed.mybooks.feature_data.domain.models.Notes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: Notes)

    suspend fun update(note: Notes)

    suspend fun deleteNote(note: Notes)

    fun getNotes(): Flow<List<Notes>>

    suspend fun getNoteById(id: Int): Notes?

    fun deleteAllNotes()


}