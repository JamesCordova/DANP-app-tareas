package com.aero.apptareas.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aero.apptareas.data.repository.ThemeRepository

class ThemeViewModel(private val themeRepository: ThemeRepository) : ViewModel() {
    var isDarkMode by mutableStateOf(themeRepository.isDarkMode())
        private set

    fun toggleTheme() {
        isDarkMode = themeRepository.toggleDarkMode()
    }
}

