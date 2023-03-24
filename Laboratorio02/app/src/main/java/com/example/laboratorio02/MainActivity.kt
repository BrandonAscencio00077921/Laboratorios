package com.example.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var weight: EditText
    private lateinit var height: EditText
    private lateinit var calculate: Button
    private lateinit var result: TextView
    private lateinit var healthy: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bin()
        addListener()
    }

    fun bin(){
        weight = findViewById(R.id.peso)
        height = findViewById(R.id.altura)
        calculate = findViewById(R.id.calcular)
        result = findViewById(R.id.resultado)
        healthy = findViewById(R.id.estado_salud)
    }

    fun addListener(){
        calculate.setOnClickListener { _ ->
            val endResult = DecimalFormat("#.##")
            val r = ((weight.text.toString().toFloat()) / ((height.text.toString()
                .toFloat())/100 * (height.text.toString().toFloat())/100))

            result.setText("" + (endResult.format(r)))
            val r1 = "Bajo de peso"
            val r2 = "Saludable"
            val r3 = "Sobre peso"
            val r4 = "Obesidad"
            if (r < 18.5) {
                healthy.text = r1
                healthy.setTextColor(ContextCompat.getColor(this,R.color.under_weight))
            }else if(r >= 18.5 && r <24.99){
                healthy.text = r2
                healthy.setTextColor(ContextCompat.getColor(this,R.color.normal_weight))
            }else if(r >= 25 && r < 29.99){
                healthy.text = r3
                healthy.setTextColor(ContextCompat.getColor(this,R.color.over_weight))
            }else if(r>=30){
                healthy.text = r4
                healthy.setTextColor(ContextCompat.getColor(this,R.color.obese))
            }else{
                healthy.text = "Ingrese los datos"
                healthy.setTextColor(ContextCompat.getColor(this,R.color.white))
            }
        }
    }

}