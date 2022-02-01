package com.megahed.mybooks.feature_data.presentation.documents

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.os.ParcelFileDescriptor
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.megahed.mybooks.R
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.domain.repository.DocumentRepository
import com.megahed.mybooks.helper.DocumentType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class DocumentViewModel @Inject constructor(
    private val repository: DocumentRepository
) : ViewModel() {

    val todos = repository.getDocuments()

    private var recentlyDeletedNote: Notes? = null

    private var getNotesJob:Job?=null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            Search_Dir(getExternalStorageDirectory())
        }

        //getNotes()
    }



    private fun getNotes() {
        getNotesJob?.cancel()
        getNotesJob = repository.getDocuments().launchIn(viewModelScope)
    }

    fun Search_Dir(dir: File) {
        val pdfPattern: String = ".pdf";

        var l=0;
        dir.listFiles()?.forEach { file ->
            if (file.isDirectory) {
                Search_Dir(file)
            } else {
                if (file.name.endsWith(pdfPattern)){
                    l++;
                    viewModelScope.launch {
                        Log.d("errorjhfdgf","item "+l+" "+ file.name)
                            repository.insertDocument(
                                Document(
                                    title = file.name,
                                    hash = "hjfd"+l,
                                    url = file.path,
                                    imageUrl = Uri.parse(
                                        "android.resource://" + R::class.java.getPackage().name + "/" + R.drawable.felengaz
                                    ).toString(),
                                    documentType = DocumentType.PDF,
                                    comment = "",
                                    rate = 0f,
                                    pagesDone = 0,
                                    pages = 0
                                )
                            )



                    }
                }
            }

        }

    }


    private fun pdfToBitmap(pdfFile: File) :Bitmap{
        var bitmap: Bitmap? = null
        if (pdfFile.exists()) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val renderer = PdfRenderer(
                        ParcelFileDescriptor.open(
                            pdfFile,
                            ParcelFileDescriptor.MODE_READ_ONLY
                        )
                    )
                    val pageCount = renderer.pageCount
                    if (pageCount >= 0) {
                        val page = renderer.openPage(0)
                        bitmap =
                            Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
                        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                        page.close()
                        renderer.close()

                        //imageView.setImageBitmap(bitmap);
                    }
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                bitmap=null
            }
        } else  bitmap=null
        return bitmap!!
    }

}