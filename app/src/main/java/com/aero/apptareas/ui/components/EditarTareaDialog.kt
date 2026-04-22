package com.aero.apptareas.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aero.apptareas.data.model.Tarea

@Composable
fun EditarTareaDialog(
    tarea: Tarea,
    textoEditado: String,
    onTextoChange: (String) -> Unit,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Editar Tarea")
        },
        text = {
            Column {
                TextField(
                    value = textoEditado,
                    onValueChange = onTextoChange,
                    label = { Text("Título de la tarea") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (textoEditado.isNotBlank()) {
                        onConfirm()
                    }
                }
            ) {
                Text("Guardar")
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = onDismiss
            ) {
                Text("Cancelar")
            }
        }
    )
}

