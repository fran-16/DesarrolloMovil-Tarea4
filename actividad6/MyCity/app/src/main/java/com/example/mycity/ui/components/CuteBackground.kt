package com.example.mycity.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun CuteBackground(content: @Composable () -> Unit) {
    val gradient = Brush.verticalGradient(
        listOf(
            Color(0xFFFFF1F7),
            Color(0xFFFFE6F1),
            Color(0xFFFFD1E5)
        )
    )
    Box(Modifier.fillMaxSize().background(gradient)) {
        content()
    }
}
