package com.example.musify.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun SegmentedButton(
    modifier: Modifier = Modifier,
    defaultSelection: Int = 0,
    items: List<String> = emptyList(),
    onItemSelection: (Int, String) -> Unit = { _, _ -> }
) {
    var selected by remember { mutableIntStateOf(defaultSelection) }

    Row(modifier = modifier) {
        items.forEachIndexed { index, value ->
            Button(
                onClick = {
                    selected = index
                    onItemSelection(index, value)
                },
                border = BorderStroke(Dp.Hairline, MaterialTheme.colorScheme.onPrimary),
                shape = when (index) {
                    0 -> RoundedCornerShape(10.dp, 0.dp, 0.dp, 10.dp)
                    items.size - 1 -> RoundedCornerShape(0.dp, 10.dp, 10.dp, 0.dp)
                    else -> RectangleShape
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = if (index == selected)
                        MaterialTheme.colorScheme.primary else
                        MaterialTheme.colorScheme.onPrimary,
                    containerColor = if (index == selected)
                        MaterialTheme.colorScheme.onPrimary else
                        MaterialTheme.colorScheme.primary
                )
            ) {
                Text(text = value)
            }
        }
    }
}

@Preview
@Composable
fun SegmentedButtonPreview() {
    MusifyTheme(darkTheme = true) {
        SegmentedButton(
            items = listOf("Test1", "Test2", "Test3")
        )
    }
}