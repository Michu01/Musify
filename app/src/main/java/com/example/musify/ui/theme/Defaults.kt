package com.example.musify.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

@Composable
fun textFieldColors() = TextFieldDefaults.colors(
    unfocusedContainerColor = MaterialTheme.colorScheme.primary,
    unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary,
    unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
    unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
    errorContainerColor = MaterialTheme.colorScheme.error,
    errorLabelColor = MaterialTheme.colorScheme.onError,
    errorTextColor = MaterialTheme.colorScheme.onError,
    errorLeadingIconColor = MaterialTheme.colorScheme.onError
)
