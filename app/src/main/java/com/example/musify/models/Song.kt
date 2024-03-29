package com.example.musify.models

import kotlin.time.Duration

class Song(
    val title: String,
    val album: Album,
    val duration: Duration
) : ImageDisplayable(title, album.cover) {
    override val route: String
        get() = "song_player"
    override val typeName: String
        get() = "Song"
}