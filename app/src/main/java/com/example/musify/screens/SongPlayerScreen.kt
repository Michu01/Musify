@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.musify.screens

import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.components.TopBar
import com.example.musify.services.dataProvider
import com.example.musify.ui.theme.MusifyTheme
import com.example.musify.utility.averageColorFromImage
import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@Composable
fun SongPlayerScreen(navController: NavController, navSelection: MutableIntState) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val song = remember { dataProvider.randomSong() }

    val resources = LocalContext.current.resources

    val avgColor = remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val image = BitmapFactory.decodeResource(resources, song.album.cover)
            averageColorFromImage(image)
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
    }

    ScreenTemplate(
        topBar = {
            TopBar(
                containerColor = avgColor,
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
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(avgColor, MaterialTheme.colorScheme.background)))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.0f)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = song.album.cover),
                    contentDescription = "Album cover"
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1.0f)) {
                    Text(
                        text = song.title,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = song.album.artist!!.name,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favourite",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
            val progress = Random.nextFloat()
            Slider(
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.onPrimary,
                    activeTrackColor = MaterialTheme.colorScheme.onPrimary
                ),
                value = progress,
                onValueChange = {}
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = song.duration
                        .times(progress.toDouble())
                        .toLong(DurationUnit.SECONDS)
                        .toDuration(DurationUnit.SECONDS)
                        .toString(),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = song.duration.toString(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center.also { Arrangement.spacedBy(10.dp) }
            ) {
                IconButton(
                    modifier = Modifier.size(50.dp),
                    onClick = {}
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Previous"
                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                        .background(MaterialTheme.colorScheme.onPrimary)
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = "Play",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(
                    modifier = Modifier.size(50.dp),
                    onClick = {}
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Next"
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(showBackground = true)
@Composable
fun SongPlayerScreenPreview() {
    MusifyTheme(darkTheme = true) {
        SongPlayerScreen(rememberNavController(), remember { mutableIntStateOf(1) })
    }
}