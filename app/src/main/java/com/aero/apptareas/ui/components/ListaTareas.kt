package com.aero.apptareas.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.aero.apptareas.data.model.Tarea
import com.aero.apptareas.ui.theme.TareaColors

@Composable
fun ListaTareas(
    tareas: List<Tarea>,
    onToggle: (Tarea) -> Unit = {},
    onDelete: (Tarea) -> Unit = {},
    onEdit: (Tarea) -> Unit = {}
) {
    LazyColumn {
        items(tareas) { tarea ->
            ItemTarea(
                tarea = tarea,
                backgroundColor = TareaColors.getColorByIndex(tarea.colorIndex),
                onToggle = { onToggle(tarea) },
                onDelete = { onDelete(tarea) },
                onEdit = { onEdit(tarea) }
            )
        }
    }
}