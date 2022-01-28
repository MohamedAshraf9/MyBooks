package com.megahed.mybooks.di

import android.app.Application
import androidx.room.Room
import com.megahed.mybooks.feature_data.data.data_source.Database
import com.megahed.mybooks.feature_data.data.repository.NoteRepositoryImpl
import com.megahed.mybooks.feature_data.domain.repository.NoteRepository
import com.megahed.mybooks.feature_data.domain.use_case.AddNote
import com.megahed.mybooks.feature_data.domain.use_case.DeleteNote
import com.megahed.mybooks.feature_data.domain.use_case.GetNotes
import com.megahed.mybooks.feature_data.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app:Application):Database{

        return Room.databaseBuilder(
            app,
            Database::class.java,
            Database.DATABASE_NAME
        ).build()

    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: Database): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            //getNote = GetNote(repository)
        )
    }

}