package com.example.andoridfirst

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.pm.PackageManager
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import android.widget.AbsListView.MultiChoiceModeListener
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.andoridfirst.databinding.ActivityMain7Binding
import com.example.andoridfirst.databinding.RegisterLayoutBinding
import com.example.andoridfirst.databinding.ToastLayoutBinding

class MainActivity7 : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    lateinit var binding: ActivityMain7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnToast.setOnClickListener(this)
        binding.btnDate.setOnClickListener(this)
        binding.btnTime.setOnClickListener(this)
        binding.btnDialog.setOnClickListener(this)
        binding.btnItemDialog.setOnClickListener(this)
        binding.btnMultiItemDialog.setOnClickListener(this)
        binding.btnSingleItemDialog.setOnClickListener(this)
        binding.btnCustomDialog.setOnClickListener(this)
        binding.btnFineLocate.setOnClickListener(this)
        binding.btnRington.setOnClickListener(this)


    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRington -> {
                // Uniform Resource Identifier, 리소스를 구분하는 식별자.
                // 사운드 소리 위치 파일을 가져온다.
                val notificationUri : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val rington = RingtoneManager.getRingtone(applicationContext,notificationUri)
                rington.play()
            }
            R.id.btnFineLocate -> {
                val state = ContextCompat.checkSelfPermission(
                    applicationContext,
                    "android.permission.ACCESS_FINE_LOCATION"
                )
                if (state == PackageManager.PERMISSION_GRANTED) {
                    binding.tvNameMessage.text = "위치추적권한허용"
                } else {
                    binding.tvNameMessage.text = "위치추적권한불허"

                }
            }
            R.id.btnCustomDialog -> {
                val userBinding: RegisterLayoutBinding
                val userDialogBuilder = AlertDialog.Builder(this)
                var userDialog: AlertDialog
                // 사용자 화면 인플렉션 하기
                userBinding = RegisterLayoutBinding.inflate(layoutInflater)
                // 사용자 다이얼로그 제목, 뷰설정 보이기
                userDialogBuilder.setTitle("사용자 이름 입력하기")
                userDialogBuilder.setIcon(R.drawable.computer_24)
                userDialogBuilder.setView(userBinding.root)
                // dialogBuilder.create() -> dialogBuilder 정보를 dismiss()를 새로 추가해서 userDialog 넘겨줌.
                userDialog = userDialogBuilder.create()
                userDialog.show()
                // 버튼 이벤트 처리
                userBinding.btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "취소하였습니다.", Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }
                userBinding.btnRegister.setOnClickListener {
                    binding.tvNameMessage.text = userBinding.edtName.text.toString()
                    Toast.makeText(applicationContext, "확인하였습니다.", Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }

            }
            R.id.btnSingleItemDialog -> {
                val items = arrayOf<String>("홍길동", "저길동", "구길동", "수길동")
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setSingleChoiceItems(items, 0, object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            binding.btnSingleItemDialog.text = items[which]
                        }
                    })
                    setNegativeButton("Close", null)
                    setCancelable(false)
                    show()
                }.setCanceledOnTouchOutside(true)
            }
            R.id.btnMultiItemDialog -> {
                val items = arrayOf<String>("홍길동", "저길동", "구길동", "수길동")
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setMultiChoiceItems(
                        items,
                        booleanArrayOf(true, false, false, false),
                        object : DialogInterface.OnMultiChoiceClickListener {
                            override fun onClick(
                                dialog: DialogInterface?,
                                which: Int,
                                isChecked: Boolean
                            ) {
                                if (isChecked == true) {
                                    binding.btnMultiItemDialog.text = items[which]
                                }
                            }
                        })
                    setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Toast.makeText(applicationContext, "선택했습니다.", Toast.LENGTH_SHORT).show()
                        }
                    })
                    setNegativeButton("Cancel", null)
                    show()
                }
            }
            R.id.btnItemDialog -> {
                var eventHandler = object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {

                        Toast.makeText(
                            this@MainActivity7, "${
                                if (which == -1) {
                                    "yes"
                                } else {
                                    "no"
                                }
                            }클릭", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                val items = arrayOf<String>("홍길동", "저길동", "구길동", "수길동")
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setItems(items, object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            binding.btnItemDialog.text = items[which]
                            Toast.makeText(
                                applicationContext,
                                "내용 : ${items[which]}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                    setNegativeButton("No", eventHandler)
                    show()
                }
            }
            R.id.btnDialog -> {
                var eventHandler = object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {

                        Toast.makeText(
                            this@MainActivity7, "${
                                if (which == -1) {
                                    "yes"
                                } else {
                                    "no"
                                }
                            }클릭", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setMessage("알림창 정보를 보여드립니다.")
                    setPositiveButton("Yes", eventHandler)
                    setNegativeButton("No", eventHandler)
                    show()
                }
            }
            R.id.btnTime -> {
                TimePickerDialog(this, this, 13, 45, true).show()
            }
            R.id.btnDate -> {
                DatePickerDialog(this, this, 2023, 3 - 1, 23).show()
            }
            R.id.btnToast -> {


                val toast = Toast.makeText(this@MainActivity7, "토스트1", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.TOP, 0, 200)
                toast.setText("정신일도 하사불성")
                toast.addCallback(
                    object : Toast.Callback() {
                        override fun onToastShown() {
                            super.onToastShown()
                            binding.btnToast.text = "토스트 보이기"
                        }

                        override fun onToastHidden() {
                            super.onToastHidden()
                            binding.btnToast.text = "토스트 감추기"

                        }
                    }
                )
//                val toastLayout = LayoutInflater.from(this@MainActivity7).inflate(R.layout.toast_layout,null)
//                toast.view = toastLayout.rootView
                var toastLayoutBinding: ToastLayoutBinding
                toastLayoutBinding = ToastLayoutBinding.inflate(layoutInflater)
                toast.view = toastLayoutBinding.root

                toastLayoutBinding.textView.setOnClickListener {
                    Log.e("toastLayout", "good")
                }

                toast.show()
            }

        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(
            applicationContext,
            "${year} ${month + 1} ${dayOfMonth}",
            Toast.LENGTH_SHORT
        ).show()

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(applicationContext, "${hourOfDay} 시 ${minute} 분", Toast.LENGTH_SHORT).show()
    }
}
