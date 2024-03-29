package com.example.musify.models

class Artist(
    val name: String,
    cover: Int
) : ImageDisplayable(name, cover) {
    override val route: String
        get() = "artist"
    override val typeName: String
        get() = "Artist"
}