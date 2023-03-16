package com.example.andoridfirst

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.andoridfirst.databinding.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivitySub19Binding
//    lateinit var binding2: ActivitySub12Binding
//    lateinit var binding3: ActivitySub11Binding
    var flag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySub19Binding.inflate(layoutInflater)
//        binding2 = ActivitySub12Binding.inflate(layoutInflater)
//        binding3 = ActivitySub11Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.tvLongClick.setOnLongClickListener{
//            binding.edtPw.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
//            Toast.makeText(applicationContext,binding.edtPw.text.toString(),Toast.LENGTH_SHORT).show()
//            Handler(Looper.getMainLooper()).postDelayed({
//
//            },2000)
//            return@setOnLongClickListener(true)
//        }
//        binding.edtPw.setOnClickListener{
//            binding.edtPw.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
//        }
//        binding.btnClick.setOnClickListener {
//        if(flag == true){
//            binding.btnTarget.visibility = View.VISIBLE
//            binding.btnGone.visibility = View.VISIBLE
//            flag = false
//        }else{
//            binding.btnTarget.visibility = View.INVISIBLE
//            binding.btnGone.visibility = View.GONE
//            flag = true
//        }
//        }
    }

}
