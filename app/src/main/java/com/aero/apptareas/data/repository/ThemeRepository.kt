package com.aero.apptareas.data.repository

import com.aero.apptareas.data.preferences.ThemePreferences

class ThemeRepository(private val themePreferences: ThemePreferences) {
    fun isDarkMode(): Boolean = themePreferences.isDarkMode()

    fun setDarkMode(isDark: Boolean) {
        themePreferences.setDarkMode(isDark)
    }

    fun toggleDarkMode(): Boolean = themePreferences.toggleDarkMode()
}

