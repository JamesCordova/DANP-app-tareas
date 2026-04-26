package com.aero.apptareas.ui.tareas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.aero.apptareas.data.model.FiltroTarea
import com.aero.apptareas.data.model.Tarea
import com.aero.apptareas.data.repository.TareaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TareasViewModel(private val repository: TareaRepository) : ViewModel() {

    var texto by mutableStateOf("")
        private set

    var tareaEnEdicion by mutableStateOf<Tarea?>(null)
        private set

    var textoEdicion by mutableStateOf("")
        private set

    var filtroActual by mutableStateOf(FiltroTarea.TODAS)
        private set

    private val _filtroFlow = MutableStateFlow(FiltroTarea.TODAS)

    val tareas = _filtroFlow
        .flatMapLatest { filtro -> repository.getTareasPorFiltro(filtro) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onTextoChange(nuevoTexto: String) {
        texto = nuevoTexto
    }

    fun agregarTarea() {
        if (texto.isNotBlank()) {
            val nuevaTarea = Tarea(
                titulo = texto,
                completada = false
            )
            viewModelScope.launch {
                repository.insertTarea(nuevaTarea)
            }
            texto = ""
        }
    }

    fun toggleTarea(tarea: Tarea) {
        viewModelScope.launch {
            repository.updateTarea(tarea.copy(completada = !tarea.completada))
        }
    }

    fun eliminarTarea(tarea: Tarea) {
        viewModelScope.launch {
            repository.deleteTarea(tarea)
        }
    }

    fun abrirEdicionTarea(tarea: Tarea) {
        tareaEnEdicion = tarea
        textoEdicion = tarea.titulo
    }

    fun cerrarEdicionTarea() {
        tareaEnEdicion = null
        textoEdicion = ""
    }

    fun onTextoEdicionChange(nuevoTexto: String) {
        textoEdicion = nuevoTexto
    }

    fun guardarEdicionTarea(nuevoTitulo: String) {
        tareaEnEdicion?.let { tarea ->
            viewModelScope.launch {
                repository.updateTarea(tarea.copy(titulo = nuevoTitulo))
                cerrarEdicionTarea()
            }
        }
    }

    fun cambiarFiltro(nuevoFiltro: FiltroTarea) {
        filtroActual = nuevoFiltro
        _filtroFlow.value = nuevoFiltro
    }
}

class TareasViewModelFactory(private val repository: TareaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TareasViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TareasViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
