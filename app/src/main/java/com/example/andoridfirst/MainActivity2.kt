package com.example.andoridfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.example.andoridfirst.databinding.ActivityMain2Binding
import com.example.andoridfirst.databinding.ActivitySub23Binding
import kotlin.math.log

class MainActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{
                Log.d("1","터치 ${event?.x} rawx = ${event.rawX}")
                Toast.makeText(applicationContext," 터치를 클릭했습니다.",Toast.LENGTH_SHORT).show()
            }
            MotionEvent.ACTION_UP ->{
                Log.d("2","터치 해제")
                Toast.makeText(applicationContext," 터치를 클릭 해제 했습니다.",Toast.LENGTH_SHORT).show()
            }
        }
        return super.onTouchEvent(event)
    }
}