package com.juanfra.optionsmenudialogosalir

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Autor: Juan Francisco Sánchez González
Fecha: 20/10/2024
Clase: Actividad que implementa un OptionsMenu con la opción para salir del aplicativo, al pulsarla
se abrirá un cuadro de diálogo (con 2 botones) para que el usuario confirme la acción.
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Inflar el menú de opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionsmenu, menu)
        return true
    }

    // Manejar la selección de elementos del menú OptionsMenu. Se mostrará un cuadro de diálogo
    // para que el usuario confirme la acción.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Creamos un cuadro de diálogo
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.tit_dialogo)) // Título
            .setMessage(getString(R.string.mensaje_dialogo)) // Mensaje
            .setIcon(R.drawable.baseline_settings_power_24) // Icono
            .setPositiveButton(getString(R.string.btn_pos_text)) { dialog, _ ->
                // Botón Aceptar - Finaliza la aplicación
                finish()
            }
            .setNegativeButton(getString(R.string.btn_neg_text)) { dialog, _ ->
                // Botón Cancelar - Cierra el diálogo
                dialog.dismiss()
            }
        val alertDialog = builder.create()
        // Muestra el cuadro de diálogo
        alertDialog.show()
        return super.onOptionsItemSelected(item)
    }
}