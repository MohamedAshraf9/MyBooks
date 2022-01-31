package com.megahed.mybooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.megahed.mybooks.feature_data.presentation.add_edit_data.AddEditNoteScreen
import com.megahed.mybooks.feature_data.presentation.documents.DocumentScreen
import com.megahed.mybooks.feature_data.presentation.notes.NotesScreen
import com.megahed.mybooks.feature_data.presentation.util.Screen
import com.megahed.mybooks.ui.theme.MyBooksTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBooksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    DocumentScreen()




                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBooksTheme {
        Greeting("Android")
    }
}

@ExperimentalAnimationApi
@Composable
fun ShowActivity() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.NotesScreen.route
    ) {
        composable(route = Screen.NotesScreen.route) {
            NotesScreen(navController = navController)
        }
        composable(
            route = Screen.AddEditNoteScreen.route +
                    "?noteId={noteId}&noteColor={noteColor}",
            arguments = listOf(
                navArgument(
                    name = "noteId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(
                    name = "noteColor"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                },
            )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(
                navController = navController,
                noteColor = color
            )
        }
    }
}