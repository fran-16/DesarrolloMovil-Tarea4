package com.example.mycity.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mycity.ui.CityViewModel
import com.example.mycity.ui.components.CuteBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    vm: CityViewModel,
    isFullScreen: Boolean,
    onBack: () -> Unit
) {
    val place = vm.ui.collectAsState().value.selected

    val content: @Composable (Modifier) -> Unit = { modifier ->
        if (place == null) {
            Text("Elige un lugar de la lista.", modifier = modifier)
        } else {
            Column(modifier) {
                place.imageUrl?.let {
                    AsyncImage(it, null, Modifier.fillMaxWidth().height(220.dp))
                }
                Spacer(Modifier.height(12.dp))
                Text(place.name, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(6.dp))
                Text(place.address, style = MaterialTheme.typography.bodyMedium)
                Spacer(Modifier.height(8.dp))
                Text(place.details, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }

    if (isFullScreen) {
        CuteBackground {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.35f),
                topBar = {
                    TopAppBar(
                        title = { Text(place?.name ?: "Detalle") },
                        navigationIcon = {
                            IconButton(onClick = onBack) { Icon(Icons.Filled.ArrowBack, "Atrás") }
                        }
                    )
                }
            ) { inner -> content(Modifier.padding(inner).padding(16.dp)) }
        }
    } else {
        content(Modifier.padding(8.dp))
    }
}
