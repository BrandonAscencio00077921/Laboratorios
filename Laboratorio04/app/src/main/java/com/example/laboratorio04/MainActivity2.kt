package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private lateinit var Nombre: TextView
    private lateinit var Correo: TextView
    private lateinit var Telefono: TextView
    private lateinit var Boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        bind()
        showInfo()
        sendInfo()
    }

    fun bind(){
        Nombre = findViewById(R.id.nombre)
        Correo = findViewById(R.id.correo)
        Telefono = findViewById(R.id.telefono)
        Boton = findViewById(R.id.send)
    }

    fun showInfo(){
        val obj: Intent = intent
        var name = obj.getStringExtra("n")
        Nombre.text = "Nombre $name"
        var email = obj.getStringExtra("c")
        Correo.text = "Correo electrónico $email"
        var number = obj.getStringExtra("t")
        Telefono.text = "Número de teléfono $number"
    }

    fun sendInfo(){
        Boton.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${Nombre.text} ${Correo.text} ${Telefono.text}")
                type = "text/plain"
            }
        val shareIntent = Intent.createChooser(intent, null)
            startActivity(shareIntent)
        }
    }
}

