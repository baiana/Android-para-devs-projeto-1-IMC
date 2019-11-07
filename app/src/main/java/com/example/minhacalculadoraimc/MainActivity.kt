package com.example.minhacalculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.linear_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_main)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        calculateBTN.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        val hasError = heightEDTX.text.isBlank() || weightEDTX.text.isBlank()
        if (hasError) {
            if (heightEDTX.text.toString().isBlank()) {
                heightEDTX.error = "Empty height"
            }
            if (weightEDTX.text.toString().isBlank()) {
                weightEDTX.error = "Empty weight"
            }
        } else {
            val bmi = calculateBMI(
                heightEDTX.text.toString().toFloat(),
                weightEDTX.text.toString().toFloat()
            ).toString().substring(0, 5)
            titleTXT.text = "Your BMI is $bmi"
        }
    }

    private fun calculateBMI(height: Float, weight: Float): Float = weight / height.pow(2)
}
