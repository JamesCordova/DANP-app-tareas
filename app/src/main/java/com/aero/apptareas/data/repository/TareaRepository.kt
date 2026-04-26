package com.aero.apptareas.data.repository

import com.aero.apptareas.data.db.TareaDao
import com.aero.apptareas.data.model.Tarea
import com.aero.apptareas.data.model.FiltroTarea
import kotlinx.coroutines.flow.Flow

class TareaRepository(private val tareaDao: TareaDao) {

    val allTareas: Flow<List<Tarea>> = tareaDao.getAllTareas()

    fun getTareasPorFiltro(filtro: FiltroTarea): Flow<List<Tarea>> {
        return when (filtro) {
            FiltroTarea.TODAS -> tareaDao.getAllTareas()
            FiltroTarea.PENDIENTES -> tareaDao.getTareasPendientes()
            FiltroTarea.COMPLETADAS -> tareaDao.getTareasCompletadas()
        }
    }

    suspend fun insertTarea(tarea: Tarea): Long {
        return tareaDao.insertTarea(tarea)
    }

    suspend fun updateTarea(tarea: Tarea) {
        tareaDao.updateTarea(tarea)
    }

    suspend fun deleteTarea(tarea: Tarea) {
        tareaDao.deleteTarea(tarea)
    }

    suspend fun getTareaById(id: Int): Tarea? {
        return tareaDao.getTareaById(id)
    }
}

