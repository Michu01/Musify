@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.musify.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.R
import com.example.musify.components.TopBar
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun PlaylistScreen(navController: NavController, navSelection: MutableIntState) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    class Entry(
        val title: String,
        val artist: String,
        val isFavourite: Boolean,
        val albumCover: Int
    )

    val entries = listOf(
        Entry(
            "Hangar 18",
            "Megadeth",
            true,
            R.drawable.rust_in_peace
        ),
        Entry(
            "Peace Sells",
            "Megadeth",
            false,
            R.drawable.peace_sells
        ),
        Entry(
            "Victory",
            "Megadeth",
            true,
            R.drawable.youthanasia
        ),
        Entry(
            "Skin O' My Teeth",
            "Megadeth",
            true,
            R.drawable.countdown_to_extinction
        ),
        Entry(
            "Mary Jane",
            "Megadeth",
            false,
            R.drawable.so_far_so_good
        ),
        Entry(
            "Seven",
            "Megadeth",
            false,
            R.drawable.risk
        ),
        Entry(
            "Youthanasia",
            "Megadeth",
            true,
            R.drawable.youthanasia
        ),
        Entry(
            "Holy Wars... The Punishment Due",
            "Megadeth",
            false,
            R.drawable.rust_in_peace
        ),
        Entry(
            "Five Magics",
            "Megadeth",
            false,
            R.drawable.rust_in_peace
        ),
        Entry(
            "Tornado Of Souls",
            "Megadeth",
            true,
            R.drawable.rust_in_peace
        ),
        Entry(
            "Symphony Of Destruction",
            "Megadeth",
            false,
            R.drawable.countdown_to_extinction
        ),
        Entry(
            "Foreclosure Of A Dream",
            "Megadeth",
            false,
            R.drawable.countdown_to_extinction
        ),
        Entry(
            "Sweating Bullets",
            "Megadeth",
            false,
            R.drawable.countdown_to_extinction
        )
    )

    ScreenTemplate(
        topBar = {
            TopBar(
                scrollBehavior = scrollBehavior,
                navController = navController,
                showNavigation = true
            )
        },
        navController = navController,
        navSelection = navSelection
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Box(modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxSize(0.5f)
                        .clip(RoundedCornerShape(10.dp, 0.dp, 0.dp, 0.dp)),
                    painter = painterResource(id = R.drawable.rust_in_peace),
                    contentDescription = "The wall"
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .fillMaxSize(0.5f)
                        .clip(RoundedCornerShape(0.dp, 10.dp, 0.dp, 0.dp)),
                    painter = painterResource(id = R.drawable.countdown_to_extinction),
                    contentDescription = "The wall"
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxSize(0.5f)
                        .clip(RoundedCornerShape(0.dp, 0.dp, 0.dp, 10.dp)),
                    painter = painterResource(id = R.drawable.peace_sells),
                    contentDescription = "The wall"
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .fillMaxSize(0.5f)
                        .clip(RoundedCornerShape(0.dp, 0.dp, 10.dp, 0.dp)),
                    painter = painterResource(id = R.drawable.youthanasia),
                    contentDescription = "The wall"
                )
            }
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Megadeth - best of",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Plus")
                        Text(text = "Add song")
                    }
                }
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
                entries.forEach {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(10)),
                            painter = painterResource(id = it.albumCover),
                            contentDescription = "Cover"
                        )
                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .weight(1.0f)
                            .clickable {
                                navController.navigate("song_player")
                            }
                        ) {
                            Text(
                                text = it.title,
                                style = MaterialTheme.typography.labelSmall
                            )
                            Text(
                                text = it.artist,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        Icon(
                            imageVector = if (it.isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favourite"
                        )
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "More"
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaylistScreenPreview() {
    MusifyTheme(darkTheme = true) {
        PlaylistScreen(rememberNavController(), remember { mutableIntStateOf(1) })
    }
}