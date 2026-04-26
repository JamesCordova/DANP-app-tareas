package com.aero.apptareas.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TarjetaBase(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Unspecified,
    contenido: @Composable () -> Unit
) {
    val cardColors = if (backgroundColor != Color.Unspecified) {
        CardDefaults.cardColors(
            containerColor = backgroundColor,
            disabledContainerColor = backgroundColor
        )
    } else {
        CardDefaults.cardColors()
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = cardColors,
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        contenido()
    }
}