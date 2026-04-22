package com.aero.apptareas.ui.tareas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aero.apptareas.ui.components.BotonPrimario
import com.aero.apptareas.ui.components.CampoTexto
import com.aero.apptareas.ui.components.ListaTareas
import com.aero.apptareas.ui.components.TituloApp

@Composable
fun TareasScreen(viewModel: TareasViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TituloApp()

        Spacer(modifier = Modifier.height(16.dp))

        CampoTexto(
            valor = viewModel.texto,
            onValorChange = viewModel::onTextoChange,
            label = "Nueva Tarea"
        )

        Spacer(modifier = Modifier.height(8.dp))

        BotonPrimario("Agregar Tarea") { viewModel.agregarTarea() }

        Spacer(modifier = Modifier.height(16.dp))

        ListaTareas(
            tareas = viewModel.tareas,
            onToggle = viewModel::toggleTarea,
            onDelete = viewModel::eliminarTarea
            )

    }
}