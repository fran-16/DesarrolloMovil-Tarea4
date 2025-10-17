package com.example.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycity.data.Category
import com.example.mycity.ui.screens.CategoryScreen
import com.example.mycity.ui.screens.DetailScreen
import com.example.mycity.ui.screens.HomeScreen
import com.example.mycity.ui.utils.ContentType

object Routes {
    const val HOME = "home"
    const val CATEGORY = "category/{cat}"
    const val DETAIL = "detail/{id}"
}

@Composable
fun MainNav(
    widthSizeClass: WindowWidthSizeClass,
    contentType: ContentType,
    vm: CityViewModel,
    onFinishApp: () -> Unit
) {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Routes.HOME) {

        // HOME — ahora SÍ pasamos 'categories'
        composable(Routes.HOME) {
            HomeScreen(
                categories = Category.entries.toList(),   // <- FIX 1
                onCategory = { category ->
                    // MUY importante usar .name (no el título visible con tildes)
                    nav.navigate("category/${category.name}")
                }
            )
        }

        // CATEGORY — parseo seguro del enum SIN referenciar un nombre específico
        composable(
            route = Routes.CATEGORY,
            arguments = listOf(navArgument("cat") { type = NavType.StringType })
        ) { back ->
            val defaultCat = Category.entries.firstOrNull() ?: return@composable  // <- FIX 2 (default genérico)
            val catName = back.arguments?.getString("cat")
            val cat = runCatching { enumValueOf<Category>(catName ?: defaultCat.name) }
                .getOrElse { defaultCat }

            vm.setCategory(cat)

            CategoryScreen(
                vm = vm,
                category = cat,
                contentType = contentType,
                onPlace = { id ->
                    vm.selectPlace(id)
                    if (contentType == ContentType.ListOnly) {
                        nav.navigate("detail/$id")
                    }
                },
                onBack = {
                    if (contentType == ContentType.ListOnly) nav.popBackStack() else onFinishApp()
                }
            )
        }

        // DETAIL
        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { back ->
            val id = back.arguments?.getInt("id") ?: return@composable
            vm.selectPlace(id)

            DetailScreen(
                vm = vm,
                isFullScreen = true,
                onBack = { nav.popBackStack() }
            )
        }
    }
}
