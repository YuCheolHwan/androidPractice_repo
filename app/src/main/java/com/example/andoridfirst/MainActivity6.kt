package com.example.andoridfirst

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowMetrics
import com.example.andoridfirst.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    lateinit var binding: ActivityMain6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 화면 정보를 가져 오는데 버전에 따라서 명령이 틀려진다. API 30 버전 이상 부터.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics : WindowMetrics = windowManager.currentWindowMetrics
            Log.e("MainActivity6","width 30 이상 : ${windowMetrics.bounds.width()} + height : ${windowMetrics.bounds.height()}")
        } else {
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            Log.e("MainActivity6","width 30 미만 : ${displayMetrics.widthPixels} + height : ${displayMetrics.heightPixels}")
        }

    }
}