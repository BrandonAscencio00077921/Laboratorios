package com.example.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var five_cents: ImageView
    private lateinit var ten_cents: ImageView
    private lateinit var quarter_coin: ImageView
    private lateinit var dollar_coin: ImageView
    private lateinit var money_count: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        setOnClickListener()
    }

    fun bind(){
        five_cents = findViewById(R.id.five_cents)
        ten_cents = findViewById(R.id.ten_cents)
        quarter_coin = findViewById(R.id.quarter_coin)
        dollar_coin = findViewById(R.id.dollar_coin)
        money_count = findViewById(R.id.money_count)
    }

    fun setOnClickListener(){
        five_cents.setOnClickListener{_->
            val decimal = DecimalFormat("#.##")
            val add005 = money_count.text.toString().toFloat() + 0.05
            money_count.setText((decimal.format(add005)))
        }
        ten_cents.setOnClickListener{_->
            val decimal = DecimalFormat("#.##")
            val add010 = money_count.text.toString().toFloat() + 0.10
            money_count.setText((decimal.format(add010)))
        }
        quarter_coin.setOnClickListener{_->
            val decimal = DecimalFormat("#.##")
            val add025 = money_count.text.toString().toFloat() + 0.25
            money_count.setText((decimal.format(add025)))
        }
        dollar_coin.setOnClickListener{_->
            val decimal = DecimalFormat("#.##")
            val add1 = money_count.text.toString().toFloat() + 1.00
            money_count.setText((decimal.format(add1)))
        }
    }
}