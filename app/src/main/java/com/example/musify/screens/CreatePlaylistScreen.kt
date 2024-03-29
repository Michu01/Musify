@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.musify.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.components.TopBar
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun CreatePlaylistScreen(navController: NavController, navSelection: MutableIntState) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

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
        Box(modifier = Modifier
            .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Create playlist",
                    style = MaterialTheme.typography.titleLarge
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Playlist name")
                    }
                )
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        navController.navigate("library")
                    }
                ) {
                    Text(text = "Create")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreatePlaylistScreenPreview() {
    MusifyTheme(darkTheme = true) {
        CreatePlaylistScreen(rememberNavController(), remember { mutableIntStateOf(1) })
    }
}