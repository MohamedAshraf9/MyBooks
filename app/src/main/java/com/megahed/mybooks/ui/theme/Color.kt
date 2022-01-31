package com.megahed.mybooks.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val DarkGray = Color(0xFF202020)
val LightBlue = Color(0xFFD7E8DE)

val RedOrange = Color(0xffffab91)
val RedPink = Color(0xfff48fb1)
val BabyBlue = Color(0xff81deea)
val Violet = Color(0xffcf94da)
val LightGreen = Color(0xffe7ed9b)

val LightPink = Color(0xFFE7B1CE)
val LightYellow = Color(0xFFF4E981)
val DarkYellow = Color(0xFFFFD24C)
val RedYellow = Color(0xFFDD3C3C)




@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}
