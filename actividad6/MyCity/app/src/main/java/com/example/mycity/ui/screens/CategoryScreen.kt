package com.example.mycity.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mycity.data.Category
import com.example.mycity.ui.CityViewModel
import com.example.mycity.ui.components.CuteBackground
import com.example.mycity.ui.utils.ContentType
import com.example.mycity.ui.utils.findActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    vm: CityViewModel,
    category: Category,
    contentType: ContentType,
    onPlace: (Int) -> Unit,
    onBack: () -> Unit
) {
    val ui = vm.ui.collectAsState().value
    val act = findActivity() // extensión segura, sin casteo directo

    CuteBackground {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.35f),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = if (contentType == ContentType.ListAndDetail)
                                "My City — Lima"
                            else
                                category.title
                        )
                    },
                    navigationIcon = {
                        if (contentType == ContentType.ListOnly) {
                            IconButton(onClick = onBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Atrás"
                                )
                            }
                        }
                    }
                )
            }
        ) { inner ->
            if (contentType == ContentType.ListAndDetail) {
                // Tablet / expandido: lista + detalle
                Row(
                    modifier = Modifier
                        .padding(inner)
                        .fillMaxSize()
                ) {
                    // LISTA
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp)
                    ) {
                        items(ui.places, key = { it.id }) { p ->
                            ElevatedCard(
                                onClick = { onPlace(p.id) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp)
                            ) {
                                PlaceRow(
                                    name = p.name,
                                    subtitle = p.short,
                                    imageUrl = p.imageUrl
                                )
                            }
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                    )

                    // DETALLE
                    Box(
                        modifier = Modifier
                            .weight(2f)
                            .padding(12.dp)
                    ) {
                        DetailScreen(
                            vm = vm,
                            isFullScreen = false,
                            onBack = { act?.finish() } // no crashea si es null
                        )
                    }
                }
            } else {
                // Teléfono: solo lista
                LazyColumn(
                    modifier = Modifier
                        .padding(inner)
                        .padding(12.dp)
                ) {
                    items(ui.places, key = { it.id }) { p ->
                        ElevatedCard(
                            onClick = { onPlace(p.id) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                        ) {
                            PlaceRow(
                                name = p.name,
                                subtitle = p.short,
                                imageUrl = p.imageUrl
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PlaceRow(
    name: String,
    subtitle: String,
    imageUrl: String?,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        if (imageUrl != null) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.size(56.dp)
            )
            Spacer(Modifier.width(12.dp))
        }
        Column(Modifier.weight(1f)) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
