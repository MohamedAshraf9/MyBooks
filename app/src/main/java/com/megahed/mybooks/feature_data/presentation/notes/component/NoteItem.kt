package com.megahed.mybooks.feature_data.presentation.notes.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.presentation.add_edit_data.myTextStyle
import com.megahed.mybooks.ui.theme.RedOrange
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun NoteItem(
    note: Notes,
    modifier: Modifier =Modifier,
    cornerRadius: Dp=10.dp,
    cutCornerSize:Dp=30.dp,
    onDeleteClick:()->Unit
) {

    val squareSize = 60.dp
    val swipeAbleState = rememberSwipeableState(initialValue = 0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, -sizePx to 1)
    Box(
        modifier = modifier
            .swipeable(
                state = swipeAbleState,
                anchors = anchors,
                thresholds = { _, _ ->
                    FractionalThreshold(0.3f)
                },
                orientation = Orientation.Horizontal
            )
    ) {

        Column(
            modifier = Modifier.align(Alignment.BottomEnd)) {

            IconButton(
                onClick = onDeleteClick

            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete note",
                    tint = MaterialTheme.colors.onSurface
                )
            }
            IconButton(
                onClick = onDeleteClick
            ) {
                Icon(
                    imageVector = Icons.Default.BookmarkBorder,
                    contentDescription = "Delete note",
                    tint =  MaterialTheme.colors.onSurface
                )
            }
        }
        
        Box(
            modifier = Modifier
                .offset {
                    IntOffset(
                        swipeAbleState.offset.value.roundToInt(), 0
                    )
                }
                .fillMaxWidth()
                //.align(Alignment.CenterStart)
                //.clip(RoundedCornerShape(cornerRadius))
            //.widthIn(0.dp,250.dp)
            //.heightIn(0.dp,200.dp),
        ) {
            Canvas(
                modifier = Modifier
                    .matchParentSize()
                    .align(Alignment.TopStart)
            ) {
                val clipPath = Path().apply {
                    lineTo(size.width - cutCornerSize.toPx(), 0f)
                    lineTo(size.width, cutCornerSize.toPx())
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                    close()
                }

                clipPath(clipPath) {
                    drawRoundRect(
                        color = Color(note.color),
                        size = size,
                        cornerRadius = CornerRadius(cornerRadius.toPx())
                    )
                    drawRoundRect(
                        color = Color(
                            ColorUtils.blendARGB(note.color, 0x000000, 0.2f)
                        ),
                        topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                        size = Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                        cornerRadius = CornerRadius(cornerRadius.toPx())
                    )
                }
            }
            Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    /*.padding(8.dp)
                    .padding(end = 32.dp)
                    .align(Alignment.TopStart)*/
                ) {
                    Text(
                        text = note.title,
                        style = myTextStyle(textStyle = MaterialTheme.typography.h6),
                        color = MaterialTheme.colors.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = note.content,
                        style = myTextStyle(textStyle = MaterialTheme.typography.body1),
                        color = MaterialTheme.colors.onSurface,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis
                    )
                }



        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun show() {
    NoteItem(
        note = Notes(1,"title","content",
            android.graphics.Color.CYAN,545464645L,1L,1)
    ) {

    }
}