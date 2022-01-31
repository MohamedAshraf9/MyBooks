package com.megahed.mybooks.feature_data.presentation.documents

import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.OndemandVideo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.megahed.mybooks.R
import com.megahed.mybooks.feature_data.domain.models.Document
import com.megahed.mybooks.feature_data.presentation.add_edit_data.myTextStyle
import com.megahed.mybooks.feature_data.presentation.components.NetworkImage
import com.megahed.mybooks.helper.DocumentType
import java.util.*
import kotlin.math.ceil

@Composable
fun DocumentItemHorizontal(
    document: Document,
    modifier: Modifier=Modifier,
    onItemClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = modifier
            .size(280.dp, 240.dp)
            .padding(8.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.clickable(onClick = { onItemClick })
        ) {

            Image(
                painter = rememberImagePainter(document.imageUrl),
                contentDescription = null, // decorative
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(135.dp)
                    .fillMaxWidth()
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = document.title,
                    style = myTextStyle(textStyle = MaterialTheme.typography.subtitle1),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = document.documentType.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = myTextStyle(textStyle = MaterialTheme.typography.body2)
                )

                Spacer(modifier = Modifier.height(2.dp))
                Row(){
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(5.dp)
                            .shadow(3.dp, CircleShape),
                        backgroundColor = Color.LightGray,
                        //color = Color.Blue, //progress color
                        progress = .25f
                    )

                }


                /*  Text(
                      text = stringResource(
                          id = R.string.home_post_min_read,
                          formatArgs = arrayOf(
                              post.metadata.date,
                              post.metadata.readTimeMinutes
                          )
                      ),
                      style = MaterialTheme.typography.body2
                  )*/
            }
        }
    }
}


@ExperimentalCoilApi
@Composable
fun DocumentItemVertical(
    document: Document,
    modifier: Modifier = Modifier,
    shape: Shape= RoundedCornerShape(10.dp),
    onItemClick: () -> Unit,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
    showCreator:Boolean=false,
    iconSize: Dp = 16.dp,
    elevation: Dp=3.dp
) {
    Surface(
        modifier = modifier.padding(4.dp),
        color = MaterialTheme.colors.surface,
        elevation = elevation,
        shape = shape
    ) {
        val featuredString = stringResource(id = R.string.app_name)
        ConstraintLayout(
            modifier = Modifier
                .clickable(
                    onClick = { onItemClick }
                )
                .semantics {
                    contentDescription = featuredString
                }
        ) {
            val (image, avatar, subject, name, steps, icon) = createRefs()
            NetworkImage(
                url = document.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(4f / 3f)
                    .constrainAs(image) {
                        centerHorizontallyTo(parent)
                        top.linkTo(parent.top)
                    }
            )
            val outlineColor = LocalElevationOverlay.current?.apply(
                color = MaterialTheme.colors.surface,
                elevation = elevation
            ) ?: MaterialTheme.colors.surface
            OutlinedAvatar(
                url = document.imageUrl,
                outlineColor = outlineColor,
                modifier = Modifier
                    .size(38.dp)
                    .constrainAs(avatar) {
                        centerHorizontallyTo(parent)
                        centerAround(image.bottom)
                    }
            )
            Text(
                text = document.documentType.name,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.overline,
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(subject) {
                        centerHorizontallyTo(parent)
                        top.linkTo(avatar.bottom)
                    }
            )
            Text(
                text = document.title,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(name) {
                        centerHorizontallyTo(parent)
                        top.linkTo(subject.bottom)
                    }
            )
            val center = createGuidelineFromStart(0.5f)
            Icon(
                imageVector = Icons.Rounded.OndemandVideo,
                tint = MaterialTheme.colors.primary,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .constrainAs(icon) {
                        end.linkTo(center)
                        centerVerticallyTo(steps)
                    }
            )
            Text(
                text = "steps",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                    .constrainAs(steps) {
                        start.linkTo(center)
                        top.linkTo(name.bottom)
                    }
            )
        }
    }
}




@Composable
fun OutlinedAvatar(
    url: String,
    modifier: Modifier = Modifier,
    outlineSize: Dp = 3.dp,
    outlineColor: Color = MaterialTheme.colors.surface
) {
    Box(
        modifier = modifier.background(
            color = outlineColor,
            shape = CircleShape
        )
    ) {
        NetworkImage(
            url = url,
            contentDescription = null,
            modifier = Modifier
                .padding(outlineSize)
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}




@Composable
fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    maxColumnWidth: Dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        check(constraints.hasBoundedWidth) {
            "Unbounded width not supported"
        }
        val columns = ceil(constraints.maxWidth / maxColumnWidth.toPx()).toInt()
        val columnWidth = constraints.maxWidth / columns
        val itemConstraints = constraints.copy(maxWidth = columnWidth)
        val colHeights = IntArray(columns) { 0 } // track each column's height
        val placeables = measurables.map { measurable ->
            val column = shortestColumn(colHeights)
            val placeable = measurable.measure(itemConstraints)
            colHeights[column] += placeable.height
            placeable
        }

        val height = colHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
            ?: constraints.minHeight
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val colY = IntArray(columns) { 0 }
            placeables.forEach { placeable ->
                val column = shortestColumn(colY)
                placeable.place(
                    x = columnWidth * column,
                    y = colY[column]
                )
                colY[column] += placeable.height
            }
        }
    }
}

private fun shortestColumn(colHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var column = 0
    colHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            column = index
        }
    }
    return column
}


@Preview(
    name = "light" ,
    showBackground = true
)
@Preview(
    name = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun show() {
  DocumentItemHorizontal(
      Document(
      1,"cxc","Book",
        "sf",
          Uri.parse(
              "android.resource://" + R::class.java.getPackage().name + "/" + R.drawable.felengaz
          ).toString(),
          DocumentType.PDF
  ), onItemClick = {})
}


