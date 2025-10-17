package com.example.mycity.data

enum class Category(val title: String) {
    REPOSTERIAS("Reposterías"),
    HELADERIAS("Heladerías"),
    PARQUES("Parques y zonas recreativas"),
    RESTAURANTES("Restaurantes"),
    SALONES_BELLEZA("Salones de belleza")
}

data class Place(
    val id: Int,
    val name: String,
    val category: Category,
    val short: String,      // resumen cortito
    val details: String,    // descripción larga
    val address: String,
    val imageUrl: String? = null
)
