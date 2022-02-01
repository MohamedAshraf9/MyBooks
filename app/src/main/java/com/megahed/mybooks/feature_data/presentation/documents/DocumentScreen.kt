package com.megahed.mybooks.feature_data.presentation.documents

import android.content.Context
import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.megahed.mybooks.R
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.helper.DocumentType
import dagger.hilt.android.lifecycle.HiltViewModel

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun DocumentScreen(
 context:Context,
 viewModel: DocumentViewModel= hiltViewModel()
) {
    val docs=viewModel.todos.collectAsState(initial = emptyList())
    Log.d("nnnnnnnnn",""+docs.value.size)
    val myLogo = BitmapFactory.decodeResource(context.getResources(), R.drawable.felengaz)
    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(16.dp)
            .padding(8.dp)
            //.statusBarsPadding()
    ){
       /* *//*LazyRow{
            items(50){
                DocumentItemHorizontal(
                    Document(
                        1,"cxc","BookBookBookBook $it",
                        "sf",
                        Uri.parse(
                            "android.resource://" + R::class.java.getPackage().name + "/" + R.drawable.felengaz
                        ).toString(),
                        DocumentType.PDF
                    ), onItemClick = {})

            }
        }*/

        LazyVerticalGrid(cells =GridCells.Adaptive(150.dp) ){
            items(docs.value){
                DocumentItemVertical(
                  it, onItemClick = {}
                    , showCreator = true, bitmap = myLogo)
            }
        }

       /* StaggeredVerticalGrid(
            maxColumnWidth = 220.dp,
            modifier = Modifier.padding(4.dp)){


        }*/
    }
    
}




@ExperimentalFoundationApi
@ExperimentalCoilApi
@Preview("Regular colors")
@Preview("Dark colors", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun show1() {
    //DocumentScreen()
}