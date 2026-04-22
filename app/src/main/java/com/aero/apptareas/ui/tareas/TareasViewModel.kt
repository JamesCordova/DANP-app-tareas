package com.aero.apptareas.ui.tareas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.aero.apptareas.data.model.Tarea

class TareasViewModel : ViewModel() {
    var tareas by mutableStateOf(listOf<Tarea>())
        private set

    var texto by mutableStateOf("")
        private set

    private var contadorId = 0

    fun onTextoChange(nuevoTexto: String) {
        texto = nuevoTexto
    }

    fun agregarTarea() {
        if (texto.isNotBlank()) {
            val nuevaTarea = Tarea(
                id = contadorId++,
                titulo = texto,
                completada = false
            )
            tareas = tareas + nuevaTarea
            texto = ""
        }
    }

    fun toggleTarea(tarea: Tarea) {
        tareas = tareas.map { itTarea: Tarea ->
            if (itTarea.id == tarea.id) {
                itTarea.copy(completada = !itTarea.completada)
            } else {
                itTarea
            }
        }
    }

    fun eliminarTarea(tarea: Tarea) {
        tareas = tareas.filter { itTarea: Tarea ->
            itTarea.id != tarea.id }
    }
}