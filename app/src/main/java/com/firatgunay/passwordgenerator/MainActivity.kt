package com.firatgunay.passwordgenerator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.firatgunay.passwordgenerator.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGenerate.setOnClickListener {
            val length = binding.editTextLength.text.toString().toIntOrNull() ?: return@setOnClickListener
            val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9') + listOf('!', '@', '#', '$', '%', '&','?', '~', '£')
            if(length > 15){
                Toast.makeText(applicationContext, "enter max 15 character", Toast.LENGTH_SHORT).show()
            }
            else{
                val password = (1..length)
                    .map { chars[Random.nextInt(0, chars.size)] }
                    .joinToString("")
                binding.textViewPassword.text = password
            }

        }
        binding.editTextLength.doOnTextChanged { _, _, _, _ ->
            binding.textViewPassword.text = ""
        }
    }
}