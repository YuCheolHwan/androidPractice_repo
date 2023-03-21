package com.example.andoridfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import com.example.andoridfirst.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity(), View.OnClickListener{
    lateinit var binding : ActivityMain4Binding
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener(this)
        binding.btnStop.setOnClickListener(this)
        binding.btnReset.setOnClickListener(this)

    }
    // SystemClock.elapsedRealtime() : 컴퓨터 부팅 부터 시작하여 경과된 시간
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnStart -> {
                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                binding.chronometer.start()
                binding.btnStart.isEnabled = false
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = true
                Toast.makeText(applicationContext,"시작합니다.",Toast.LENGTH_SHORT).show()
            }

            R.id.btnStop -> {
                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = true
                Toast.makeText(applicationContext,"정지합니다.",Toast.LENGTH_SHORT).show()
            }

            R.id.btnReset -> {
                binding.chronometer.base = SystemClock.elapsedRealtime()
                pauseTime = 0L
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = false
                Toast.makeText(applicationContext,"초기화합니다.",Toast.LENGTH_SHORT).show()
            }
            else -> null
        }
    }
}