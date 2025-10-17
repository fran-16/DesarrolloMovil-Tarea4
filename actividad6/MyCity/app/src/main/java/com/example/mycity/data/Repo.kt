package com.example.mycity.data

object Repo {
    val places = listOf(
        // Reposterías
        Place(1,"Pastelería del Malecón",Category.REPOSTERIAS,"Tortas caseras y milhojas",
            "Repostería clásica con vitrinas de tartas, milhojas y piononos. Ideal para una tarde con vista al mar.",
            "Malecón de la Reserva 123, Miraflores","https://picsum.photos/seed/reposteria1/900/500"),
        Place(2,"Dulce Barranquino",Category.REPOSTERIAS,"Cheesecake y tartaletas",
            "Cheesecake cremoso y opciones sin gluten en ambiente acogedor.",
            "Av. San Martín 456, Barranco","https://picsum.photos/seed/reposteria2/900/500"),
        Place(3,"Horno Artesanal",Category.REPOSTERIAS,"Tortas húmedas y queques",
            "Bizcochos de chocolate y zanahoria. Café filtrado para acompañar.",
            "Calle Las Magnolias 78, Surco","https://picsum.photos/seed/reposteria3/900/500"),

        // Heladerías
        Place(4,"Gelato del Parque",Category.HELADERIAS,"Gelatos artesanales",
            "Sabores naturales y conos crocantes hechos al día.",
            "Parque Central 890, Miraflores","https://picsum.photos/seed/heladeria1/900/500"),
        Place(5,"Nieve Chacarera",Category.HELADERIAS,"Helados y sorbetes",
            "Sorbetes frutales y opciones veganas.",
            "Av. Caminos del Inca 230, Surco","https://picsum.photos/seed/heladeria2/900/500"),
        Place(6,"La Copita Feliz",Category.HELADERIAS,"Helados con toppings",
            "Combina helados con brownie, crocante y frutas.",
            "Jr. Las Flores 321, San Borja","https://picsum.photos/seed/heladeria3/900/500"),

        // Parques y zonas recreativas
        Place(7,"Parque del Amor",Category.PARQUES,"Vista al mar y esculturas",
            "Jardines coloridos, esculturas y miradores románticos en el malecón.",
            "Malecón Cisneros, Miraflores","https://picsum.photos/seed/parque1/900/500"),
        Place(8,"Parque de la Amistad",Category.PARQUES,"Tradición y juegos",
            "Locomotora antigua, laguna con botes y juegos para niños.",
            "Av. Caminos del Inca, Surco","https://picsum.photos/seed/parque2/900/500"),
        Place(9,"Parque de las Leyendas",Category.PARQUES,"Zoológico y cultura",
            "Animales, zonas arqueológicas y áreas de picnic. Ideal para familias.",
            "Av. Las Leyendas 580, San Miguel","https://picsum.photos/seed/parque3/900/500"),

        // Restaurantes
        Place(10,"Costazul Fresco",Category.RESTAURANTES,"Mar y brasa casual",
            "Pesca del día, parrilla ligera y ambiente familiar.",
            "Av. Del Mar 230, Miraflores","https://picsum.photos/seed/rest1/900/500"),
        Place(11,"Barranco Bistró",Category.RESTAURANTES,"Cocina de autor",
            "Menú de temporada con presentación elegante.",
            "Jr. Saénz Peña 210, Barranco","https://picsum.photos/seed/rest2/900/500"),
        Place(12,"Ajiaco Criollo",Category.RESTAURANTES,"Cocina tradicional",
            "Ají de gallina, lomo saltado y sopas caseras.",
            "Av. Colonial 1450, Centro","https://picsum.photos/seed/rest3/900/500"),

        // Salones de belleza
        Place(13,"Studio Glam",Category.SALONES_BELLEZA,"Peinados & color",
            "Balayage, keratina y tratamientos capilares.",
            "Av. Pardo 520, Miraflores","https://picsum.photos/seed/salon1/900/500"),
        Place(14,"Belle Femme",Category.SALONES_BELLEZA,"Manicure & spa",
            "Manicure gel, spa de manos y pies.",
            "Av. Primavera 300, Surco","https://picsum.photos/seed/salon2/900/500"),
        Place(15,"Cabello & Arte",Category.SALONES_BELLEZA,"Barbería & cortes",
            "Barbería clásica, afeitado a navaja y estilos modernos.",
            "Jr. Las Magnolias 12, San Borja","https://picsum.photos/seed/salon3/900/500"),
    )

    fun categories() = Category.values().toList()
    fun byCategory(c: Category) = places.filter { it.category == c }
    fun byId(id: Int) = places.first { it.id == id }
}
