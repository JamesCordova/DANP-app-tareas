package com.aero.apptareas.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aero.apptareas.data.model.Tarea
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDao {

    @Query("SELECT * FROM tareas ORDER BY id DESC")
    fun getAllTareas(): Flow<List<Tarea>>

    @Query("SELECT * FROM tareas WHERE id = :id")
    suspend fun getTareaById(id: Int): Tarea?

    @Insert
    suspend fun insertTarea(tarea: Tarea): Long

    @Update
    suspend fun updateTarea(tarea: Tarea)

    @Delete
    suspend fun deleteTarea(tarea: Tarea)

    @Query("DELETE FROM tareas")
    suspend fun deleteAllTareas()
}

