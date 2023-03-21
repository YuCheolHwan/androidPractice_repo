package com.example.andoridfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.example.andoridfirst.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding : ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClick1.setOnClickListener (this)
        binding.btnClick2.setOnClickListener (this)
        binding.btnClick3.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext,"버튼 3 클릭",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnClick4.setOnClickListener {
            Toast.makeText(applicationContext,"버튼 4 클릭",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnClick1 -> Toast.makeText(applicationContext,"버튼 1 클릭",Toast.LENGTH_SHORT).show()
            R.id.btnClick2 -> Toast.makeText(applicationContext,"버튼 2 클릭",Toast.LENGTH_SHORT).show()
        }
    }
}