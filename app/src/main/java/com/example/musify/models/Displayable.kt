package com.example.musify.models

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

abstract class Displayable {
    @Composable
    abstract fun DisplayGrid(navController: NavController)

    @Composable
    abstract fun DisplayList(navController: NavController)
}