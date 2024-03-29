package com.example.musify.models

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musify.utility.randomColor

class Suggestion(
    private val title: String,
    private val description: String
) : Displayable() {
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
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10))
                    .background(Brush.verticalGradient(listOf(randomColor(), Color.Black)))
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Text(
                text = description,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }

    @Composable
    override fun DisplayList(navController: NavController) {

    }
}