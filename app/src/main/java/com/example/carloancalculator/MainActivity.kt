package com.example.carloancalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var start : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        start = findViewById(R.id.start)

        start.setOnClickListener(View.OnClickListener {
            val i = Intent(
                this@MainActivity,
                MainActivity2::class.java
            )
            startActivity(i)
        })
    }
}