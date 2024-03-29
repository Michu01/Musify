package com.example.musify.models

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

class Playlist(
    val name: String,
    val color: Color
) : Displayable() {
    @Composable
    private fun CoverImage(
        size: Dp,
        displayText: Boolean
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(10))
                .background(
                    Brush.verticalGradient(
                        listOf(
                            color,
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
        ) {
            if (displayText) {
                Text(
                    text = "Playlist",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.BottomCenter),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }

    @Composable
    override fun DisplayGrid(navController: NavController) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .clickable {
                    navController.navigate("playlist")
                },
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CoverImage(120.dp, true)
            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }

    @Composable
    override fun DisplayList(navController: NavController) {
        Row(
            modifier = Modifier.clickable {
                navController.navigate("playlist")
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CoverImage(60.dp, false)
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.0f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = "Playlist",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}