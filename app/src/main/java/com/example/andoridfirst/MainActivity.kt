package com.example.andoridfirst

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.andoridfirst.databinding.*
import java.util.*

class MainActivity : AppCompatActivity() {
//    lateinit var binding: ActivitySub20Binding
    lateinit var binding: ActivitySub23Binding

    //    lateinit var binding2: ActivitySub12Binding
//    lateinit var binding3: ActivitySub11Binding
    var flag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivitySub20Binding.inflate(layoutInflater)
        binding = ActivitySub23Binding.inflate(layoutInflater)


//        binding2 = ActivitySub12Binding.inflate(layoutInflater)
//        binding3 = ActivitySub11Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSelect1.setOnClickListener {
            if(flag == true){
                binding.screen1.visibility = View.VISIBLE
                binding.screen2.visibility = View.INVISIBLE
                flag = false
            }else{
                binding.screen1.visibility = View.INVISIBLE
                binding.screen2.visibility = View.VISIBLE
                flag = true
            }

        }
        binding.btnSelect2.setOnClickListener {

        }
        // FrameLayout -> LinerLayout 1번화면
        binding.imgPicture1.setOnClickListener {
            Toast.makeText( this, "1번화면입니다" , Toast.LENGTH_SHORT).show()
        }
        // FrameLayout -> LinerLayout 1번화면
        binding.imgPicture2.setOnClickListener {
            Toast.makeText( this, "2번화면입니다" , Toast.LENGTH_SHORT).show()
        }
        // 비밀번호 보이게 하기
        // 초기값
//        binding.chbVisible.isChecked = false
//        binding.chbVisible.text = "invisible"
//
//        binding.chbVisible.setOnClickListener {
//            // 암호를 보여줄 것
//            if (binding.chbVisible.isChecked == true) {
//                binding.edtPassword2.inputType = InputType.TYPE_CLASS_TEXT
//                binding.chbVisible.text = "visible"
//            } else {
//            // 암호를 가릴 것
//                binding.edtPassword2.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
//                binding.chbVisible.text = "invisible"
//            }
//        }


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
