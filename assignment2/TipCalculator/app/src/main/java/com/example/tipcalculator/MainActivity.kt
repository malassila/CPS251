package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateTip.setOnClickListener {

            val bill = binding.billAmount.text.toString()
            if(bill!=""){
                var finalBill = 0.00
                finalBill += bill.toDouble()
                val finalBill10 = finalBill+(finalBill * .10)
                val finalBill15 = finalBill+(finalBill * .15)
                val finalBill20 = finalBill+(finalBill * .20)

                binding.output.text= "The tips are as follows:\n\n10% = $"+String.format("%.2f", finalBill10)+"\n15% = $"+String.format("%.2f", finalBill15)+"\n20% = $"+String.format("%.2f", finalBill20)

            }else{
                binding.output.text = "YOU MUST ENTER A BILL AMOUNT"
            }
        }
    }

}








