package com.example.musify.utility

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import kotlin.math.floor
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.Q)
fun averageColorFromImage(image: Bitmap): Color {
    var red = 0.0f
    var green = 0.0f
    var blue = 0.0f

    val n = floor(0.001 * image.height * image.width).toInt();

    for (i in 0..n) {
        val x = Random.nextInt(image.width);
        val y = Random.nextInt(image.height);
        val color = image.getColor(x, y)
        red += color.red()
        green += color.green()
        blue += color.blue()
    }

    red /= n
    green /= n
    blue /= n

    return Color(red, green, blue)
}