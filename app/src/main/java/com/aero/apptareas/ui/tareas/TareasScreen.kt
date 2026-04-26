package com.aero.apptareas.ui.tareas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aero.apptareas.data.db.AppDatabase
import com.aero.apptareas.data.repository.TareaRepository
import com.aero.apptareas.ui.components.BotonPrimario
import com.aero.apptareas.ui.components.BotonToggleTema
import com.aero.apptareas.ui.components.CampoTexto
import com.aero.apptareas.ui.components.EditarTareaDialog
import com.aero.apptareas.ui.components.FiltroEstados
import com.aero.apptareas.ui.components.ListaTareas
import com.aero.apptareas.ui.components.TituloApp
import com.aero.apptareas.ui.components.TopTitleBar
import com.aero.apptareas.ui.theme.ThemeViewModel

@Composable
fun TareasScreen(
    themeViewModel: ThemeViewModel,
    viewModel: TareasViewModel = viewModel(factory = getTareasViewModelFactory())
) {
    val tareas by viewModel.tareas.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        TopTitleBar(themeViewModel)

        Spacer(modifier = Modifier.height(16.dp))

        CampoTexto(
            valor = viewModel.texto,
            onValorChange = viewModel::onTextoChange,
            label = "Nueva Tarea"
        )

        Spacer(modifier = Modifier.height(8.dp))

        BotonPrimario("Agregar Tarea") { viewModel.agregarTarea() }

        Spacer(modifier = Modifier.height(16.dp))

        FiltroEstados(
            filtroActual = viewModel.filtroActual,
            onFiltroChange = viewModel::cambiarFiltro
        )

        Spacer(modifier = Modifier.height(16.dp))

        ListaTareas(
            tareas = tareas,
            onToggle = viewModel::toggleTarea,
            onDelete = viewModel::eliminarTarea,
            onEdit = viewModel::abrirEdicionTarea
        )

        viewModel.tareaEnEdicion?.let { tarea ->
            EditarTareaDialog(
                tarea = tarea,
                textoEditado = viewModel.textoEdicion,
                onTextoChange = viewModel::onTextoEdicionChange,
                onConfirm = { viewModel.guardarEdicionTarea(viewModel.textoEdicion) },
                onDismiss = viewModel::cerrarEdicionTarea
            )
        }
    }
}

@Composable
private fun getTareasViewModelFactory(): TareasViewModelFactory {
    val context = LocalContext.current
    return remember {
        val database = AppDatabase.getInstance(context)
        val repository = TareaRepository(database.tareaDao())
        TareasViewModelFactory(repository)
    }
}

@Preview(showBackground = true)
@Composable
fun TareasScreenPreview() {
    // Preview comentado temporalmente - requiere contexto
    // TareasScreen(themeViewModel)
}