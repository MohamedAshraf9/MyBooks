package com.megahed.mybooks.feature_data.domain.use_case

import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Notes? {
        return repository.getNoteById(id)
    }
}