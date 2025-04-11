package com.example.animeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animeapp.presentation.anime_detail.AnimeDetailScreen
import com.example.animeapp.presentation.anime_detail.AnimeDetailViewModel
import com.example.animeapp.presentation.anime_list.AnimeScreen
import com.example.animeapp.presentation.anime_list.AnimeViewModel
import com.example.animeapp.presentation.ui.theme.AnimeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.AnimeList.route) {
                composable(Screen.AnimeList.route) {
                    val viewModel: AnimeViewModel = hiltViewModel()
                    AnimeScreen(viewModel, navController)
                }
                composable(Screen.AnimeDetail.route) {
                    val viewModel: AnimeDetailViewModel = hiltViewModel()
                    AnimeDetailScreen(viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimeAppTheme { }
}