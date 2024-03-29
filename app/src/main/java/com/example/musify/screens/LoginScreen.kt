package com.example.musify.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musify.ui.theme.MusifyTheme

@Composable
fun LoginScreen() {
    val textFieldColors = TextFieldDefaults.colors(
        unfocusedContainerColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
        unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
        errorContainerColor = MaterialTheme.colorScheme.error,
        errorLabelColor = MaterialTheme.colorScheme.onError,
        errorTextColor = MaterialTheme.colorScheme.onError,
        errorLeadingIconColor = MaterialTheme.colorScheme.onError
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(horizontal = 60.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Please sign in to continue",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                TextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Email")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                    },
                    colors = textFieldColors
                )
                TextField(
                    value = "aaaa",
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = {},
                    isError = true,
                    label = {
                        Text(text = "Password")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock")
                    },
                    supportingText = {
                        Text(text = "Password must be at least 8 characters long")
                    },
                    colors = textFieldColors
                )
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.align(Alignment.End),
                onClick = {}
            ) {
                Row (horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(text = "Log in")
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Arrow forward"
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Don't have an account?",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "Sign up",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MusifyTheme(darkTheme = true) {
        LoginScreen()
    }
}