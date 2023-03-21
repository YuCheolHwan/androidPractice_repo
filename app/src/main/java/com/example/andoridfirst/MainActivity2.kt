package com.example.andoridfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.CompoundButton
import android.widget.Toast
import com.example.andoridfirst.databinding.ActivityMain2Binding
import com.example.andoridfirst.databinding.ActivitySub23Binding
import kotlin.math.log

class MainActivity2 : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // 1번, 2번
        binding.ckbClick.setOnCheckedChangeListener(this)
        binding.ckbClick2.setOnCheckedChangeListener(this)
        // 3번
        binding.ckbClick3.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Toast.makeText(applicationContext, "3번 클릭", Toast.LENGTH_SHORT).show()
            }
        })
        // 4번
        binding.ckbClick4.setOnCheckedChangeListener { buttonView, isChecked ->
            Toast.makeText(applicationContext, "4번 클릭", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            R.id.ckbClick -> Toast.makeText(applicationContext, "1번 클릭", Toast.LENGTH_SHORT).show()
            R.id.ckbClick2 -> Toast.makeText(applicationContext, "2번 클릭", Toast.LENGTH_SHORT).show()

        }
    }
}

