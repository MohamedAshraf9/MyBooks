package com.megahed.mybooks.feature_data.presentation.add_edit_data

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)