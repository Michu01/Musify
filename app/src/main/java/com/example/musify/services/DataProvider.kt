package com.example.musify.services

import com.example.musify.R
import com.example.musify.models.Album
import com.example.musify.models.Artist
import com.example.musify.models.Displayable
import com.example.musify.models.Playlist
import com.example.musify.models.Song
import com.example.musify.models.Suggestion
import com.example.musify.utility.randomColor
import kotlin.random.Random
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class DataProvider {
    val artists = listOf(
        Artist(
            "Pink Floyd",
            R.drawable.pink_floyd
        ),
        Artist(
            "AC/DC",
            R.drawable.ac_dc
        ),
        Artist(
            "Megadeth",
            R.drawable.megadeth
        ),
        Artist(
            "Queen",
            R.drawable.queen
        ),
        Artist(
            "Black Sabbath",
            R.drawable.black_sabbath
        )
    )
    val albums = listOf(
        Album(
            "The Dark Side Of The Moon",
            R.drawable.the_dark_side_of_the_moon,
            artists.find { it.name == "Pink Floyd" }!!
        ),
        Album(
            "The Wall",
            R.drawable.the_wall,
            artists.find { it.name == "Pink Floyd" }!!
        ),
        Album(
            "The Piper At The Gates Of Dawn",
            R.drawable.piper_at_the_gates_of_dawn,
            artists.find { it.name == "Pink Floyd" }!!
        ),
        Album(
            "Wish You Were Here",
            R.drawable.wish_you_were_here,
            artists.find { it.name == "Pink Floyd" }!!
        ),
        Album(
            "Animals",
            R.drawable.animals,
            artists.find { it.name == "Pink Floyd" }!!
        ),
        Album(
            "Meddle",
            R.drawable.meddle,
            artists.find { it.name == "Pink Floyd" }!!
        ),
        Album(
            "Peace Sells... But Who's Buying?",
            R.drawable.peace_sells,
            artists.find { it.name == "Megadeth" }!!
        ),
        Album(
            "Rust In Peace",
            R.drawable.rust_in_peace,
            artists.find { it.name == "Megadeth" }!!
        ),
        Album(
            "Youthanasia",
            R.drawable.youthanasia,
            artists.find { it.name == "Megadeth" }!!
        ),
        Album(
            "So Far So Good... So What?",
            R.drawable.so_far_so_good,
            artists.find { it.name == "Megadeth" }!!
        ),
        Album(
            "Countdown To Extinction",
            R.drawable.countdown_to_extinction,
            artists.find { it.name == "Megadeth" }!!
        ),
        Album(
            "Risk",
            R.drawable.risk,
            artists.find { it.name == "Megadeth" }!!
        ),
        Album(
            "A Night At The Opera",
            R.drawable.a_night_at_the_opera,
            artists.find { it.name == "Queen" }!!
        ),
    )
    val songs = listOf(
        Song(
            "Peace Sells",
            albums.find { it.title == "Peace Sells... But Who's Buying?" }!!,
            duration = 4.minutes + 2.seconds
        ),
        Song(
            "Another Brick In The Wall, Part 2",
            albums.find { it.title == "The Wall" }!!,
            duration = 3.minutes + 48.seconds
        ),
        Song(
            "Money",
            albums.find { it.title == "The Dark Side Of The Moon" }!!,
            duration = 6.minutes + 20.seconds
        ),
        Song(
            "Rust In Peace... Polaris",
            albums.find { it.title == "Rust In Peace" }!!,
            duration = 5.minutes + 36.seconds
        ),
        Song(
            "Pigs (Three Different Ones)",
            albums.find { it.title == "Animals" }!!,
            duration = 11.minutes + 26.seconds
        ),
        Song(
            "Astronomy Domine",
            albums.find { it.title == "The Piper At The Gates Of Dawn" }!!,
            duration = 4.minutes + 11.seconds
        ),
        Song(
            "Youthanasia",
            albums.find { it.title == "Youthanasia" }!!,
            duration = 4.minutes + 9.seconds
        ),
        Song(
            "Sweating Bullets",
            albums.find { it.title == "Countdown To Extinction" }!!,
            duration = 5.minutes + 27.seconds
        ),
        Song(
            "Wish You Were Here",
            albums.find { it.title == "Wish You Were Here" }!!,
            duration = 5.minutes + 4.seconds
        ),
        Song(
            "One Of These Days",
            albums.find { it.title == "Meddle" }!!,
            duration = 5.minutes + 55.seconds
        )
    )
    val playlists = listOf(
        Playlist("Rock songs", randomColor()),
        Playlist("Party", randomColor()),
        Playlist("90s", randomColor()),
        Playlist("Chill", randomColor()),
        Playlist("Best of 2023", randomColor())
    )
    val suggestions = listOf(
        Suggestion(
            title = "Time capsule",
            description = "Your favourite songs from the past"
        ),
        Suggestion(
            title = "Discover this week",
            description = "Suggested songs based on your preferences"
        ),
        Suggestion(
            title = "Others' choice",
            description = "Songs from users with taste similar to yours"
        )
    )

    fun randomArtist(): Artist {
        return artists[Random.nextInt(artists.size)]
    }

    fun randomAlbum(): Album {
        return albums[Random.nextInt(albums.size)]
    }

    fun randomPlaylist(): Playlist {
        return playlists[Random.nextInt(playlists.size)]
    }

    fun randomSong(): Song {
        return songs[Random.nextInt(songs.size)]
    }

    fun randomDisplayable(): Displayable {
        return when (Random.nextInt(3)) {
            0 -> randomArtist()
            1 -> randomAlbum()
            2 -> randomPlaylist()
            else -> throw Exception()
        }
    }

    fun search(query: String): List<Displayable> {
        return (
            artists.filter { it.name.contains(query, true) } +
            songs.filter { it.title.contains(query, true) } +
            albums.filter { it.title.contains(query, true) } +
            playlists.filter { it.name.contains(query, true) }
            ).filterIsInstance<Displayable>()
    }
}

val dataProvider = DataProvider()