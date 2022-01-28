package com.megahed.mybooks.feature_data.domain.use_case

import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(Exception::class)
    suspend operator fun invoke(note: Notes) {
        if(note.title.isBlank()) {
            throw Exception("The title of the note can't be empty.")
        }
        if(note.content.isBlank()) {
            throw Exception("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}