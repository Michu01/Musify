package com.example.musify.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun Navigation(
    navController: NavController,
    navSelection: MutableIntState
) {
    val colors = NavigationBarItemDefaults.colors(
        indicatorColor = MaterialTheme.colorScheme.onPrimary
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        NavigationBarItem(
            icon = {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            },
            label = { Text("Search") },
            selected = navSelection.intValue == 0,
            onClick = {
                navSelection.intValue = 0
                navController.navigate("search")
            },
            colors = colors
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Filled.Home, contentDescription = "Home")
            },
            label = { Text("Home") },
            selected = navSelection.intValue == 1,
            onClick = {
                navSelection.intValue = 1
                navController.navigate("home")
            },
            colors = colors
        )
        NavigationBarItem(
            icon = {
                Icon(Icons.Filled.List, contentDescription = "Library")
            },
            label = { Text("Library") },
            selected = navSelection.intValue == 2,
            onClick = {
                navSelection.intValue = 2
                navController.navigate("library")
            },
            colors = colors
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    MusifyTheme(darkTheme = true) {
        Navigation(rememberNavController(), remember { mutableIntStateOf(1) })
    }
}