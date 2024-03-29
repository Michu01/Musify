@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.musify

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musify.screens.AlbumScreen
import com.example.musify.screens.ArtistScreen
import com.example.musify.screens.CreatePlaylistScreen
import com.example.musify.screens.LibraryScreen
import com.example.musify.screens.LoginScreen
import com.example.musify.screens.PlaylistScreen
import com.example.musify.screens.SearchScreen
import com.example.musify.screens.SettingsScreen
import com.example.musify.screens.SongPlayerScreen
import com.example.musify.screens.TwoFactorAuthScreen
import com.example.musify.screens.WelcomeScreen
import com.example.musify.screens.home.HomeScreen
import com.example.musify.services.NotificationService
import com.example.musify.ui.theme.MusifyTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val notificationChannel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                "notification",
                "Default",
                NotificationManager.IMPORTANCE_DEFAULT
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

        setContent {
            MusifyTheme(darkTheme = true) {
                val postNotificationPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    rememberPermissionState(permission = android.Manifest.permission.POST_NOTIFICATIONS)
                } else {
                    TODO("VERSION.SDK_INT < TIRAMISU")
                }
                val notificationService = NotificationService(this)
                LaunchedEffect(key1 = true) {
                    if(!postNotificationPermission.status.isGranted) {
                        postNotificationPermission.launchPermissionRequest()
                    }
                }
                if (postNotificationPermission.status.isGranted) {
                    notificationService.showNotification()
                }
                val navController = rememberNavController()
                val navSelection = remember { mutableIntStateOf(1) }
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable(route = "welcome") {
                        WelcomeScreen()
                    }
                    composable(route = "login") {
                        LoginScreen()
                    }
                    composable(route = "two_factor_auth") {
                        TwoFactorAuthScreen()
                    }
                    composable(route = "home") {
                        HomeScreen(navController, navSelection)
                    }
                    composable(route = "library") {
                        LibraryScreen(navController, navSelection)
                    }
                    composable(route = "search") {
                        SearchScreen(navController, navSelection)
                    }
                    composable(route = "playlist") {
                        PlaylistScreen(navController, navSelection)
                    }
                    composable(route = "create_playlist") {
                        CreatePlaylistScreen(navController, navSelection)
                    }
                    composable(route = "artist") {
                        ArtistScreen(navController, navSelection)
                    }
                    composable(route = "album") {
                        AlbumScreen(navController, navSelection)
                    }
                    composable(route = "settings") {
                        SettingsScreen(navController, navSelection)
                    }
                    composable(route = "song_player") {
                        SongPlayerScreen(navController, navSelection)
                    }
                }
            }
        }
    }
}

