package com.example.andoridfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import com.example.andoridfirst.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() , View.OnClickListener{
    lateinit var binding : ActivityMain4Binding
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnStart ->{
                binding.chronometer.base = SystemClock.elapsedRealtime()
                binding.chronometer.start()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = false
            }
            R.id.btnStop ->{

            }
            R.id.btnReset ->{

            }

        }
    }


}