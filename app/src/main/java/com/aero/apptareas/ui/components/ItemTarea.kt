package com.aero.apptareas.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aero.apptareas.data.model.Tarea
import com.aero.apptareas.ui.theme.TareaColors

@Composable
fun ItemTarea(
    tarea: Tarea,
    backgroundColor: Color = Color.White,
    onToggle: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit = {}
) {
    TarjetaBase(
        backgroundColor = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Checkbox(
                    checked = tarea.completada,
                    onCheckedChange = { onToggle() },
                    colors = MaterialTheme.colorScheme.run {
                        androidx.compose.material3.CheckboxDefaults.colors(
                            checkedColor = Color.Gray,
                            uncheckedColor = Color.Black,
                            checkmarkColor = Color.White
                        )
                    }
                )
                Text(
                    text = tarea.titulo,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1f),
                    color = if (tarea.completada) Color.Gray else Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row {
                IconButton(onClick = onEdit, modifier = Modifier.padding(0.dp)) {
                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Editar",
                        tint = if (tarea.completada) Color.Gray else Color.Black
                    )
                }
                IconButton(onClick = onDelete, modifier = Modifier.padding(0.dp)) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        tint = if (tarea.completada) Color.Gray else Color.Black
                    )
                }
            }
        }
    }
}