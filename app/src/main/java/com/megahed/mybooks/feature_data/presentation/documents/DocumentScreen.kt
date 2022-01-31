package com.megahed.mybooks.feature_data.presentation.documents

import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.megahed.mybooks.R
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.helper.DocumentType

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun DocumentScreen(

) {
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
            items(20){
                DocumentItemVertical(
                    Document(
                        1,"cxc","BookBookBookBook $it",
                        "sf",
                        Uri.parse(
                            "android.resource://" + R::class.java.getPackage().name + "/" + R.drawable.felengaz
                        ).toString(),
                        DocumentType.PDF
                    ), onItemClick = {}
                    , showCreator = true)
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
    DocumentScreen()
}