package com.example.tiptime

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener{calculateTip()}


    }

    private fun calculateTip() {
        val cost = binding.costOfServices.text.toString().toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage =when(selectedId) {
            R.id.opsi20 -> 0.2
            R.id.opsi18 -> 0.18
            else -> 0.15
        }
        var tip = cost*tipPercentage
        val roundUp = binding.roundtip.isChecked
        if (roundUp){
            tip = ceil(tip)
        }
        val currencytip = NumberFormat.getCurrencyInstance().format(tip)
        binding.hasil.text = getString( R.string.tip_amount, currencytip)//currencytip
    }
}