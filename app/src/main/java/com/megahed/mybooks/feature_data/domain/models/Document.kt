package com.megahed.mybooks.feature_data.domain.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.megahed.mybooks.helper.DocumentType

@Entity(
   /* indices = [
        Index(value = ["hash"], unique = true)
    ]*/
)
data class Document(
    val hash:String,
    val title:String,
    val url:String,
    val imageUrl:String,
    val documentType: DocumentType,
    val comment:String="",
    val rate:Float=0f,
    val pagesDone:Int=0,
    val pages:Int=0


){
    @PrimaryKey(autoGenerate = true) var docId:Long=0
}
