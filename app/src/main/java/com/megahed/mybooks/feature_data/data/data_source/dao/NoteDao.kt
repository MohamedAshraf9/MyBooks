package com.megahed.mybooks.feature_data.data.data_source.dao

import androidx.room.*
import com.megahed.mybooks.feature_data.domain.models.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Notes)

    @Update
    suspend fun update(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)

    @Query("SELECT * FROM notes")
    fun getNotes(): Flow<List<Notes>>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): Notes?


    @Query("DELETE FROM notes")
    fun deleteAllNotes()


}