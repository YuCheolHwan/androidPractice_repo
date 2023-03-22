package com.example.andoridfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.example.andoridfirst.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    lateinit var binding: ActivityMain5Binding
    var pauseTime = 0L
    var initTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                binding.chronometer.start()
                binding.tvMessage2.text = getString(R.string.btn_start)
                binding.tvMessage2.textSize = resources.getDimension(R.dimen.txt_size_large)

                binding.tvMessage2.setTextColor(ResourcesCompat.getColor(resources, R.color.txt_color2,null))
                binding.btnStart.isEnabled = false
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = true
            }
        })
        binding.btnStop.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.tvMessage2.text = getString(R.string.btn_stop)
                binding.tvMessage2.textSize = resources.getDimension(R.dimen.txt_size_small)
                binding.tvMessage2.setTextColor(ResourcesCompat.getColor(resources, R.color.txt_color,null))

                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = true
            }
        })
        binding.btnReset.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                binding.chronometer.base = SystemClock.elapsedRealtime()
                pauseTime = 0L
                binding.tvMessage2.textSize = resources.getDimension(R.dimen.txt_size_medium)
                binding.tvMessage2.text = getString(R.string.btn_reset)
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = false
            }
        })
    }


    // 백버튼을 가져 올려고 한다. (볼륨 조절, 전원, 백버튼, 키보드(옛날거))
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            if(System.currentTimeMillis() - initTime > 3000){
//                Toast.makeText(applicationContext, "종료하시려면 3초안에 한번 더  눌러주세요.", Toast.LENGTH_SHORT).show()
//                initTime = System.currentTimeMillis()
//                return true
//            }
//        }
//        return super.onKeyDown(keyCode, event)
//    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - initTime > 3000) {
            binding.tvMessage2.text = getString(R.string.btn_back)
            Toast.makeText(applicationContext, getString(R.string.btn_back), Toast.LENGTH_SHORT)
                .show()
            initTime = System.currentTimeMillis()
        } else {
            super.onBackPressed()
        }
    }
}