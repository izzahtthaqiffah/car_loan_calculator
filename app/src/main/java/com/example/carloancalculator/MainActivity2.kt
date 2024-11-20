package com.example.carloancalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var ug: Button
    private lateinit var calc: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        ug = findViewById(R.id.ug)
        calc = findViewById(R.id.calc)

        ug.setOnClickListener(View.OnClickListener {
            val i = Intent(
                this@MainActivity2,
                MainActivity4::class.java
            )
            startActivity(i)
        })

        calc.setOnClickListener(View.OnClickListener {
            val i = Intent(
                this@MainActivity2,
                MainActivity3::class.java
            )
            startActivity(i)
        })
    }
}