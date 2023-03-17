package com.example.andoridfirst

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintProperties.WRAP_CONTENT
import androidx.core.content.ContextCompat
import com.example.andoridfirst.databinding.ActivitySub20Binding
import com.example.andoridfirst.databinding.Apptest1Binding

class SubActivity : AppCompatActivity() {
    lateinit var binding: ActivitySub20Binding
    var flag : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySub20Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}