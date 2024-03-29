package com.example.musify.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

abstract class ImageDisplayable(
    private val title: String,
    private val image: Int
) : Displayable() {
    abstract val route: String
    abstract val typeName: String

    @Composable
    override fun DisplayGrid(navController: NavController) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .clickable {
                    navController.navigate(route)
                },
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = title,
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
                navController.navigate(route)
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = image),
                contentDescription = "Cover"
            )
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.0f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = typeName,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}