package com.example.musify.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musify.components.Navigation
import com.example.musify.components.SongPlayer

@Composable
fun ScreenTemplate(
    showPlayer: Boolean = false,
    navController: NavController,
    navSelection : MutableIntState,
    topBar: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Scaffold (
        topBar = topBar,
        bottomBar = {
            Navigation(navController, navSelection)
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxHeight()
            .padding(innerPadding)
        ) {
            content()
            if (showPlayer) {
                SongPlayer(
                    navController = navController,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(10.dp)
                )
            }
        }
    }
}