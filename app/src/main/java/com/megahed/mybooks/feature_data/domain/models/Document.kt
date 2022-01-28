package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.megahed.mybooks.helper.DocumentType

@Entity(
    indices = [
        Index(value = ["hash"], unique = true)]
)
data class Document(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val hash:String,
    val title:String,
    val url:String,
    val imageUrl:String,
    val documentType: DocumentType,
    val comment:String,
    val rate:Int,
    val pagesDone:Int,
    val pages:Int


)
