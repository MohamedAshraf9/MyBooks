package com.megahed.mybooks.feature_data.presentation.notes.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.megahed.mybooks.feature_data.domain.models.Notes
import com.megahed.mybooks.feature_data.presentation.add_edit_data.myTextStyle

@Composable
fun NoteItem(
    note: Notes,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
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
                .padding(16.dp)
                .padding(end = 24.dp)
        ) {
            Text(
                text = note.title,
                style = myTextStyle(MaterialTheme.typography.h6),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.content,
                style = myTextStyle( MaterialTheme.typography.body1),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black
            )
        }
        IconButton(
            onClick = onDeleteClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete note",
                tint = Color.Black
            )
        }
    }
}


@Composable
@Preview
fun show() {
    NoteItem(
        note = Notes(1,"title","content",
            android.graphics.Color.CYAN,545464645L,1L,1)
    ) {

    }
}