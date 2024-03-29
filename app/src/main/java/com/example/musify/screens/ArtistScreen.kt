@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.musify.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.R
import com.example.musify.components.TopBar
import com.example.musify.models.Album
import com.example.musify.ui.theme.MusifyTheme
import java.text.DecimalFormat
import kotlin.random.Random

@Composable
fun ArtistScreen(navController: NavController, navSelection: MutableIntState) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    class Song(val title: String, val views: Int)

    val randomViews = { Random.nextInt(1_000_000_000) }

    val songs = listOf(
        Song("Another brick in the wall, part 2", randomViews()),
        Song("Wish you were here", randomViews()),
        Song("Comfortably numb", randomViews()),
        Song("Breathe (in the air)", randomViews()),
        Song("Money", randomViews())
    ).sortedByDescending { it.views }

    val albums = listOf(
        Album(title = "The wall", cover = R.drawable.the_wall, year = 1979),
        Album(title = "The dark side of the moon", cover = R.drawable.the_dark_side_of_the_moon, year = 1973),
        Album(title = "Animals", cover = R.drawable.animals, year = 1977),
        Album(title = "Wish you were here", cover = R.drawable.wish_you_were_here, year = 1975)
    )

    ScreenTemplate(
        topBar = {
            TopBar(
                scrollBehavior = scrollBehavior,
                navController = navController,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                showNavigation = true
            )
        },
        navController = navController,
        navSelection = navSelection
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(id = R.drawable.pink_floyd),
                    contentDescription = "The wall"
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(horizontal = 10.dp),
                    text = "Pink Floyd",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FilterChip(
                        selected = true,
                        onClick = { },
                        label = {
                            Text(
                                text = "Following",
                                style = MaterialTheme.typography.labelMedium
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.onPrimary,
                            selectedLabelColor = MaterialTheme.colorScheme.primary,
                        )
                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "Play",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    songs.forEachIndexed { index, song ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                modifier = Modifier.width(12.dp),
                                text = (index + 1).toString()
                            )
                            Column(
                                modifier = Modifier
                                    .weight(1.0f)
                                    .clickable {
                                        navController.navigate("song_player")
                                    }
                            ) {
                                Text(
                                    text = song.title,
                                    style = MaterialTheme.typography.labelSmall
                                )
                                Text(
                                    text = DecimalFormat("###,###,###").format(song.views),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "More"
                            )
                        }
                    }
                }
                Text(text = "Popular releases")
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    albums.forEach { album ->
                        Row(
                            modifier = Modifier.clickable {
                                navController.navigate("album")
                            },
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(10)),
                                painter = painterResource(id = album.cover),
                                contentDescription = album.title
                            )
                            Column {
                                Text(
                                    text = album.title,
                                    style = MaterialTheme.typography.labelMedium
                                )
                                Text(
                                    text = album.year.toString(),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtistScreenPreview() {
    MusifyTheme(darkTheme = true) {
        ArtistScreen(rememberNavController(), remember { mutableIntStateOf(1) })
    }
}