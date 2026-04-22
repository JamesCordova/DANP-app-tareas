package com.aero.apptareas.ui.tareas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aero.apptareas.data.model.Tarea
import com.aero.apptareas.ui.components.BotonPrimario
import com.aero.apptareas.ui.components.CampoTexto
import com.aero.apptareas.ui.components.ListaTareas
import com.aero.apptareas.ui.components.TituloApp

@Composable
fun TareasScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TituloApp()

        Spacer(modifier = Modifier.height(16.dp))

        CampoTexto(
            valor = "",
            onValorChange = { /* TODO: Manejar el cambio de texto */ },
            label = "Nueva Tarea"
        )

        Spacer(modifier = Modifier.height(8.dp))

        BotonPrimario("Agregar Tarea") { /* TODO: Manejar el clic del botón */ }

        Spacer(modifier = Modifier.height(16.dp))

        ListaTareas(
            tareas = listOf<Tarea>(), // empty list
            onToggle = {/* TODO: Manejar el toggle de completada */ },
            onDelete = { /* TODO: Manejar el borrado de tarea */ }
            )

    }
}