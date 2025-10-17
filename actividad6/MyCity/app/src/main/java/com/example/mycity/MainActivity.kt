package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.ui.CityViewModel
import com.example.mycity.ui.MainNav
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.ui.utils.ContentType

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {
                Surface {
                    // 1) Tamaño de ventana
                    val windowSize = calculateWindowSizeClass(this)
                    val widthClass = windowSize.widthSizeClass

                    // 2) Elegir tipo de contenido según el ancho
                    val contentType = when (widthClass) {
                        WindowWidthSizeClass.Expanded -> ContentType.ListAndDetail
                        else -> ContentType.ListOnly
                    }

                    // 3) VM
                    val vm: CityViewModel = viewModel()

                    // 4) NAV: reemplaza CityNavGraph por MainNav
                    MainNav(
                        widthSizeClass = widthClass,
                        contentType = contentType,
                        vm = vm,
                        onFinishApp = { finish() }
                    )
                }
            }
        }
    }
}
