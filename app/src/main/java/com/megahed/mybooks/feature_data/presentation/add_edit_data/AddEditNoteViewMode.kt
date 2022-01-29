package com.megahed.mybooks.feature_data.presentation.add_edit_data

import androidx.lifecycle.ViewModel
import com.megahed.mybooks.feature_data.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddEditNoteViewMode @Inject constructor(
    private val noteUseCases: NoteUseCases
):ViewModel(){

}