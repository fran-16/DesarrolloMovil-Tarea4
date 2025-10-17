package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class CityUiState(
    val categories: List<Category> = Repo.categories(),
    val currentCategory: Category? = null,
    val places: List<Place> = emptyList(),
    val selected: Place? = null
)

class CityViewModel : ViewModel() {
    private val _ui = MutableStateFlow(CityUiState())
    val ui: StateFlow<CityUiState> = _ui

    fun setCategory(c: Category) {
        _ui.value = _ui.value.copy(
            currentCategory = c,
            places = Repo.byCategory(c),
            selected = null
        )
    }

    fun selectPlace(id: Int) { _ui.value = _ui.value.copy(selected = Repo.byId(id)) }
    fun clearSelection() { _ui.value = _ui.value.copy(selected = null) }
}
