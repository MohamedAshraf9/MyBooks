package com.megahed.mybooks.feature_data.domain.use_case

import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
)  {

    suspend  operator fun invoke(note: Notes){
        noteRepository.deleteNote(note)
    }
}