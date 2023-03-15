package com.example.andoridfirst

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.andoridfirst.databinding.ActivitySub2Binding
import com.example.andoridfirst.databinding.ActivitySub3Binding

class MainActivity : AppCompatActivity() {
        lateinit var binding : ActivitySub2Binding
        var flag : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClick.setOnClickListener {
            Toast.makeText(applicationContext,"유철환님 반갑습니다",Toast.LENGTH_SHORT).show()
            if(flag == true){
            binding.tvClassName.text = "안웁 3기"
                flag = false
            }else{
            binding.tvClassName.text = "철환 3기"
            flag = true
            }
        }

    }
}