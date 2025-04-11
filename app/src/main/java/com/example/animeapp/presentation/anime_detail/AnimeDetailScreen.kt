package com.example.animeapp.presentation.anime_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnimeDetailScreen(viewModel: AnimeDetailViewModel) {
    val anime by viewModel.anime.collectAsState()

    if (anime != null) {
        val data = anime!!
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = rememberAsyncImagePainter(data.imageUrl),
                contentDescription = data.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Score: ${data.score}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Type: ${data.type}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Episodes: ${data.episodes} • Duration: ${data.duration}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Status: ${data.status}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Aired: ${data.aired}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Rank: #${data.rank} • Popularity: #${data.popularity}",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (data.studios.isNotEmpty()) {
                Text(
                    text = "Studios: ${data.studios.joinToString()}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            if (data.genres.isNotEmpty()) {
                Text(
                    text = "Genres: ${data.genres.joinToString()}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = data.synopsis,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            CircularProgressIndicator()
        }
    }
}
