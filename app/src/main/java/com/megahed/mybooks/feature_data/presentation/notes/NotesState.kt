package com.megahed.mybooks.feature_data.presentation.notes

import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.util.NoteOrder
import com.megahed.mybooks.feature_data.domain.util.OrderType


data class NotesState(
    val notes: List<Notes> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)