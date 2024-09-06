package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cal.setOnClickListener {
            val Hight1 = binding.feet.text.toString().toDouble()
            val Hight2 = binding.inch.text.toString().toDouble()
            val weight = binding.weight.text.toString().toDouble()

            val totalheight = (Hight1 * 0.3048)+(Hight2*0.0254)
            val bmi = weight/(totalheight*totalheight)

            if (bmi<=18.5){
                binding.tvdisplay.text = String.format("Are you Under Weight")
            }
            else if (bmi>18.5 && bmi<25){
                binding.tvdisplay.text = String.format("Are you Normal Weight")
            }
            else if (bmi>=25 && bmi<30){
                binding.tvdisplay.text = String.format("Are you Over Weight")
            }
            else if (bmi>=30 && bmi<35){
                binding.tvdisplay.text = String.format("Are you Obese Class I")
            }
            else if (bmi>=35 && bmi<40){
                binding.tvdisplay.text = String.format("Are you Obese Class II")
            }
            else if (bmi>=40.0) {
                binding.tvdisplay.text = String.format("Are you Obese Class III")
            }

            binding.tvdisplay2.text = String.format("Your BMI Score is:- %.2f",bmi)
        }
    }
}
