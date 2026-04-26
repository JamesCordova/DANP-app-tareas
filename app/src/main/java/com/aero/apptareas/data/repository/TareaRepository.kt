package com.aero.apptareas.data.repository

import com.aero.apptareas.data.db.TareaDao
import com.aero.apptareas.data.model.Tarea
import kotlinx.coroutines.flow.Flow

class TareaRepository(private val tareaDao: TareaDao) {

    val allTareas: Flow<List<Tarea>> = tareaDao.getAllTareas()

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

