package com.example.musify.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.services.dataProvider
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun RecentlyPlayed(navController: NavController) {
    val displayableList = listOf(
        dataProvider.albums[2],
        dataProvider.artists[4],
        dataProvider.playlists[0],
        dataProvider.albums[3],
        dataProvider.artists[2]
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Recently played",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleMedium
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(displayableList) {
                it.DisplayGrid(navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecentlyPlayedPreview() {
    MusifyTheme(darkTheme = true) {
        RecentlyPlayed(rememberNavController())
    }
}