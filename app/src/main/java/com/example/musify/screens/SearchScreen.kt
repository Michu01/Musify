@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.musify.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musify.components.TopBar
import com.example.musify.services.dataProvider
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun SearchScreen(navController: NavController, navSelection: MutableIntState) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    var query by remember { mutableStateOf("") }
    var results by remember { mutableStateOf(dataProvider.search(query)) }

    ScreenTemplate(
        navController = navController,
        navSelection = navSelection,
        topBar = {
            TopBar(
                scrollBehavior = scrollBehavior,
                navController = navController,
                title = "Search"
            )
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = query,
                placeholder = {
                    Text("What do you want to listen to?")
                },
                onValueChange = {
                    query = it
                    results = dataProvider.search(query)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                results.forEach {
                    it.DisplayList(navController = navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    MusifyTheme(darkTheme = true) {
        SearchScreen(
            navController = rememberNavController(),
            navSelection = remember { mutableIntStateOf(0) }
        )
    }
}