package com.example.carloancalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var ePrice: EditText
    private lateinit var ePay: EditText
    private lateinit var eLoan: EditText
    private lateinit var eInt: EditText
    private lateinit var gen: Button
    private lateinit var display: TextView
    private lateinit var trash: ImageButton
    private lateinit var bck: ImageButton

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        // Declare components
        ePrice = findViewById(R.id.ePrice)
        ePay = findViewById(R.id.ePay)
        eLoan = findViewById(R.id.eLoan)
        eInt = findViewById(R.id.eInt)
        gen = findViewById(R.id.gen)
        display = findViewById(R.id.display)
        trash = findViewById(R.id.trash)
        bck = findViewById(R.id.bck)

        bck.setOnClickListener(View.OnClickListener {
            val i = Intent(
                this@MainActivity3,
                MainActivity2::class.java
            )
            startActivity(i)
        })

        // Function button calculate
        gen.setOnClickListener {
            try {
                // Input values
                val price = ePrice.text.toString().toDouble()
                val pay = ePay.text.toString().toDouble()
                val loanYears = eLoan.text.toString().toDouble()
                val annualInterestRate = eInt.text.toString().toDouble()

                // Calculations
                val loanAmount = price - pay // Loan Amount
                val monthlyInterestRate = annualInterestRate / 12 / 100 // Monthly Interest Rate
                val numberOfMonths = loanYears * 12 // Loan Tenure in Months

                // EMI Formula
                val emi = if (monthlyInterestRate != 0.0) {
                    (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) /
                            (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1)
                } else {
                    loanAmount / numberOfMonths // No interest case
                }

                // Display result
                display.text = "Monthly Payment (EMI): RM %.2f".format(emi)
            } catch (e: Exception) {
                display.text = "Invalid input. Please try again."
            }
        }

        // Clear button functionality
        trash.setOnClickListener {
            ePrice.text.clear()
            ePay.text.clear()
            eLoan.text.clear()
            eInt.text.clear()
            display.text = ""
        }
    }
}
