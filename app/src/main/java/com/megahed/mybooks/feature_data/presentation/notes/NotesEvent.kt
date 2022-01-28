package com.megahed.mybooks.feature_data.presentation.notes

import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Notes): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}