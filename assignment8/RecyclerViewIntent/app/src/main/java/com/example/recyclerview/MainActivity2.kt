package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.MainActivityBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return

        val title = extras.getString("title")
        val details = extras.getString("details")
        val image = extras.getString("image")!!



        binding.title.text = title
        binding.detail.text = details
        binding.imageView.setImageResource(image.toInt())
    }
}




