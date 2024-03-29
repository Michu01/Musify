@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.musify.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.R
import com.example.musify.components.TopBar
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun AlbumScreen(navController: NavController, navSelection: MutableIntState) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val songs = listOf(
        "In the flesh?",
        "The thin ice",
        "Another brick in the wall, part 1",
        "The happiest days of our lives",
        "Another brick in the wall, part 2",
        "Mother",
        "Goodbye blue sky",
        "Empty spaces",
        "Young lust",
        "One of my turns",
        "Don't leave me now",
        "Another brick in the wall, part 3",
        "Goodbye cruel world"
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
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(id = R.drawable.the_wall),
                    contentDescription = "The wall"
                )
            }
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "The Wall",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10)),
                    painter = painterResource(id = R.drawable.pink_floyd),
                    contentDescription = "Pink Floyd",
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.weight(1.0f)) {
                    Text(
                        text = "Pink Floyd",
                        style = MaterialTheme.typography.titleSmall,
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "Album",
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = "1979",
                            style = MaterialTheme.typography.bodySmall,
                        )
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
                songs.forEach {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Column(
                            modifier = Modifier
                                .weight(1.0f)
                                .clickable {
                                    navController.navigate("song_player")
                                }
                        ) {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.labelSmall
                            )
                            Text(
                                text = "Pink Floyd",
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumScreenPreview() {
    MusifyTheme(darkTheme = true) {
        AlbumScreen(rememberNavController(), remember { mutableIntStateOf(1) })
    }
}