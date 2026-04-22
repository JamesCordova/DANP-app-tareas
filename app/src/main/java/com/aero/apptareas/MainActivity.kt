package com.aero.apptareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aero.apptareas.ui.tareas.TareasScreen
import com.aero.apptareas.ui.theme.AppTareasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTareasTheme {
                TareasScreen()
            }
        }
    }
}