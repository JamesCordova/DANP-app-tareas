package com.aero.apptareas.ui.theme

import androidx.compose.ui.graphics.Color

object TareaColors {
    val availableColors = listOf(
        Color(0xFFD4BFA8), // Beige natural (por defecto)
        Color(0xFFC9956E), // Naranja cálido
        Color(0xFFD48C7A), // Salmón suave
        Color(0xFFB896A8), // Mauve
        Color(0xFF9BA8C4), // Lavanda
        Color(0xFF7BA3C0), // Azul grisáceo
        Color(0xFF7DBBB0), // Teal suave
        Color(0xFF8BA882), // Verde sage
        Color(0xFFC4B896), // Khaki
        Color(0xFFB8956A), // Tan
    )

    fun getColorByIndex(index: Int): Color =
        if (index in availableColors.indices) availableColors[index] else availableColors[0]
}