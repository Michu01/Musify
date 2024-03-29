@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.musify.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.components.SegmentedButton
import com.example.musify.components.TopBar
import com.example.musify.models.Displayable
import com.example.musify.services.dataProvider
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun LibraryScreen(
    navController: NavController,
    navSelection: MutableIntState
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val defaultSelection = 0

    fun getData(index: Int): List<Displayable> {
        return when (index) {
            0 -> dataProvider.playlists
            1 -> dataProvider.albums
            2 -> dataProvider.artists
            else -> emptyList()
        }
    }

    var data by remember { mutableStateOf(getData(defaultSelection)) }

    ScreenTemplate(
        navController = navController,
        navSelection = navSelection,
        topBar = {
            TopBar(
                scrollBehavior = scrollBehavior,
                navController = navController,
                title = "Library",
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                    IconButton(
                        onClick = {
                            navController.navigate("create_playlist")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Create playlist"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SegmentedButton(
                defaultSelection = defaultSelection,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                items = listOf("Playlists", "Albums", "Artists"),
                onItemSelection = { index, _ -> data = getData(index) }
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                data.forEach {
                    it.DisplayList(navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun LibraryScreenPreview() {
    MusifyTheme(darkTheme = true) {
        LibraryScreen(
            rememberNavController(),
            remember { mutableIntStateOf(2) }
        )
    }
}