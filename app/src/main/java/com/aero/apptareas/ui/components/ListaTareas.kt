package com.aero.apptareas.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.aero.apptareas.data.model.Tarea

@Composable
fun ListaTareas(
    tareas: List<Tarea>,
    onToggle: (Tarea) -> Unit = {},
    onDelete: (Tarea) -> Unit = {}
) {
    LazyColumn {
        items(tareas) { tarea ->
            ItemTarea(
                tarea = tarea,
                onToggle = { onToggle(tarea) },
                onDelete = { onDelete(tarea) }
            )
        }
    }
}