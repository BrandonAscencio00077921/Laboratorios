package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var nombre: TextInputEditText
    private lateinit var correo: TextInputEditText
    private lateinit var telefono: TextInputEditText
    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addEventListener()
    }

    fun bind(){
        nombre = findViewById(R.id.name)
        correo = findViewById(R.id.email)
        telefono = findViewById(R.id.number)
        boton = findViewById(R.id.save)
    }

    fun addEventListener(){
        boton.setOnClickListener {
            var intent = Intent(MainActivity@this, MainActivity2::class.java)
            intent.putExtra("n", nombre.text.toString())
            intent.putExtra("c", correo.text.toString())
            intent.putExtra("t", telefono.text.toString())
            startActivity(intent)

        }
    }
}