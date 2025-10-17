package com.example.mycity.ui.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Desde un Composable:
@Composable
fun findActivity(): Activity? = LocalContext.current.activity()

// Desde cualquier Context:
fun Context.activity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.activity()
    else -> null
}
