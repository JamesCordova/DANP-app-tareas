package com.aero.apptareas.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tareas")
data class Tarea(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val completada: Boolean = false,
    val colorIndex: Int = 0 // Just color index, the colors are in app
)