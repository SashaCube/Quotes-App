package com.example.myapplication.ui.view

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

@Composable
fun DarkModeButton() {
    val isNightMode = mutableStateOf(
        AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
    )
    Button(onClick = {
        isNightMode.value = !isNightMode.value

        // set system mode
        AppCompatDelegate.setDefaultNightMode(
            if (isNightMode.value) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
        )
    }) {
        Text(text = "turn ${if (isNightMode.value) "off" else "on"} dark mode")
    }
}