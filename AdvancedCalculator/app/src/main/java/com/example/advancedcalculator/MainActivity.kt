package com.example.advancedcalculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.advancedcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9,
            binding.btnDot
        )

        val operationButtons = listOf(
            binding.btnPlus, binding.btnMinus, binding.btnMul, binding.btnDivide
        )


        for (button in numberButtons) {
            button.setOnClickListener {
                binding.tvExpression.append(button.text)
            }
        }
        for (button in operationButtons) {
            button.setOnClickListener {
                binding.tvExpression.append(" ${button.text} ")
            }
        }

        binding.btnAC.setOnClickListener {
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
        }


        binding.btnEqual.setOnClickListener {
            val expression = binding.tvExpression.text.toString()
            val result = evaluateExpression(expression).toString()
            binding.tvResult.text = result
            Log.d("Result",result)
        }
    }

    private fun evaluateExpression(expression: String): Int {
        return try {
//            val parts = expression.trim().split("\\s+".toRegex())
            val parts = expression.trim().split("\\s".toRegex())

            if (parts.size == 3) {
                val operand1 = parts[0].toInt()
                val operator = parts[1]
                val operand2 = parts[2].toInt()

                when (operator) {
                    "+" -> operand1 + operand2
                    "-" -> operand1 - operand2
                    "X" -> operand1 * operand2
                    "/" -> operand1 / operand2
                    else -> 0
                }
            } else {
                0
            }
        } catch (e: Exception) {
            0
        }
    }

}
