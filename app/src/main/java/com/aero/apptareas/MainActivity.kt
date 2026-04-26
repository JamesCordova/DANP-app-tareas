package com.aero.apptareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.aero.apptareas.data.preferences.ThemePreferences
import com.aero.apptareas.data.repository.ThemeRepository
import com.aero.apptareas.ui.tareas.TareasScreen
import com.aero.apptareas.ui.theme.AppTareasTheme
import com.aero.apptareas.ui.theme.ThemeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeViewModel = remember {
                val themePreferences = ThemePreferences(this@MainActivity)
                val themeRepository = ThemeRepository(themePreferences)
                ThemeViewModel(themeRepository)
            }
            AppTareasTheme(
                darkTheme = themeViewModel.isDarkMode
            ) {
                TareasScreen(themeViewModel)
            }
        }
    }
}