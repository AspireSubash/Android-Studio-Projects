package com.example.basiccalculatorapp1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basiccalculatorapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlus.setOnClickListener {
            performCalculation { input1, input2 -> input1 + input2 }
        }

        binding.btnMinus.setOnClickListener {
            performCalculation { input1, input2 -> input1 - input2 }
        }

        binding.btnDivide.setOnClickListener {
            performCalculation { input1, input2 ->
                if (input2 != 0) input1.toDouble() / input2.toDouble()
                else null
            }
        }

        binding.btnMul.setOnClickListener {
            performCalculation { input1, input2 -> input1 * input2 }
        }
    }

    private fun performCalculation(operation: (Int, Int) -> Any?) {
        val input1 = binding.eTInput1.text.toString().toIntOrNull()
        val input2 = binding.eTInput2.text.toString().toIntOrNull()

        if (input1 != null && input2 != null) {
            val result = operation(input1, input2)

            if (result != null) {
                binding.tvResult.text = result.toString()
            } else {
                binding.tvResult.text = getString(R.string.division_by_zero)
            }
        } else {
            binding.tvResult.text = getString(R.string.invalid_input)
        }
    }
}
