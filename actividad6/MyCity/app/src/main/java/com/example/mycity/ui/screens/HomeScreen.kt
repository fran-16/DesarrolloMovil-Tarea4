package com.example.mycity.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Category
import com.example.mycity.ui.components.CuteBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    categories: List<Category>,
    onCategory: (Category) -> Unit
) {
    CuteBackground {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.35f),
            topBar = { TopAppBar(title = { Text("My City – Lima") }) }
        ) { inner ->
            Column(Modifier.padding(inner).padding(16.dp)) {
                categories.forEach { c ->
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .clickable { onCategory(c) }
                    ) {
                        ListItem(headlineContent = { Text(c.title) })
                    }
                }
            }
        }
    }
}
