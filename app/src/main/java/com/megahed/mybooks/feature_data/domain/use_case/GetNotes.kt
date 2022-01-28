package com.megahed.mybooks.feature_data.domain.use_case

import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.repository.NoteRepository
import com.megahed.mybooks.feature_data.domain.util.NoteOrder
import com.megahed.mybooks.feature_data.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//use case class
class GetNotes(
    private val noteRepository: NoteRepository
) {

    operator fun invoke(
        order: NoteOrder=NoteOrder.Date(OrderType.Descending)
    ):Flow<List<Notes>>{

        return noteRepository.getNotes().map { notes->
            when(order.orderType){
                is OrderType.Ascending -> {
                    when (order) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date ->notes.sortedBy { it.time }
                        is NoteOrder.Color ->notes.sortedBy { it.color }
                    }
                }

                is OrderType.Descending ->{
                    when (order) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date ->notes.sortedByDescending { it.time }
                        is NoteOrder.Color ->notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }

}