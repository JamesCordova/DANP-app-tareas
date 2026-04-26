package com.aero.apptareas.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BotonToggleTema(
    isDarkMode: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onToggle,
        modifier = modifier.padding(8.dp)
    ) {
        Icon(
            imageVector = if (isDarkMode) Icons.Outlined.DarkMode else Icons.Outlined.LightMode,
            contentDescription = if (isDarkMode) "Cambiar a modo claro" else "Cambiar a modo oscuro",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}


