package com.example.andoridfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andoridfirst.databinding.ActivitySub5Binding

class SubActivity5 : AppCompatActivity() {
    lateinit var binding : ActivitySub5Binding
    var flag : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySub5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.text = "바꿨다"
    }
}