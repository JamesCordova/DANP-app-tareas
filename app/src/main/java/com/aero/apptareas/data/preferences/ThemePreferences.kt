package com.aero.apptareas.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class ThemePreferences(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "theme_prefs"
        private const val DARK_MODE_KEY = "dark_mode"
    }

    fun isDarkMode(): Boolean = sharedPreferences.getBoolean(DARK_MODE_KEY, false)

    fun setDarkMode(isDark: Boolean) {
        sharedPreferences.edit { putBoolean(DARK_MODE_KEY, isDark) }
    }

    fun toggleDarkMode(): Boolean {
        val nextValue = !isDarkMode()
        setDarkMode(nextValue)
        return nextValue
    }
}

