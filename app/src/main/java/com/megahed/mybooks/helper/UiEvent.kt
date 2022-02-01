package com.megahed.mybooks.helper

import com.megahed.mybooks.feature_data.presentation.add_edit_data.AddEditNoteViewModel

sealed class UiEvent {
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): UiEvent()
    object SaveNote: UiEvent()
}