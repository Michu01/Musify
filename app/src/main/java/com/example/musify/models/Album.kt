package com.example.musify.models

class Album(
    val title: String,
    val cover: Int,
    val artist: Artist? = null,
    val year: Int? = null
) : ImageDisplayable(title, cover) {
    override val route: String
        get() = "album"
    override val typeName: String
        get() = "Album"
}