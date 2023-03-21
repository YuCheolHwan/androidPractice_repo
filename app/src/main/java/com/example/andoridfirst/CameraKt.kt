package com.example.CameraKt

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.andoridfirst.databinding.ActivityCameraKtBinding
import com.example.andoridfirst.databinding.ActivityMainBinding
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CameraKt : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1 //카메라 사진 촬영 요청 코드
    lateinit var curPhotoPath: String //문자열 형태의 사진 경로 값(초기값을 null로 저장하고 시작하고 싶을때)

    lateinit var binding: ActivityCameraKtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraKtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setPermission() // 권한을 체크하는 것을 실행

        binding.btnCamera.setOnClickListener {
            takeCapture() //기본 카메라 앱을 실행하여 사진 촬영
        }
    }

    // 카메라 촬영
    private fun takeCapture() {
        // 기본 카메라 앱 실행
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    val pdotoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.android.application.fileprovider",
                        it
                    )

                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, pdotoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    //이미지 파일 생성
    private fun createImageFile(): File? {
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDit: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timestamp}_", ".jpg", storageDit)
            .apply { curPhotoPath = absolutePath }
    }

    //테드 퍼미션 설정
    private fun setPermission() {
        val permission = object : PermissionListener {
            override fun onPermissionGranted() { // 설정해놓은 위험권한들이 허용 되었을 경우 이 곳을 수행함
                Toast.makeText(this@CameraKt, "권한이 허용 되었습니다", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) { // 설정해놓은 위험권한 들 중 거부를 한 경우 이곳을 수행함
                Toast.makeText(this@CameraKt, "권한이 거부 되었습니다", Toast.LENGTH_SHORT).show()
            }
        }

        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라앱을 사용하시려면 권한을 허용해주세요")
            .setDeniedMessage("권한을 거부하셔습니다 [앱 설정] -> [권한] 항목에서 허용해주세요")
            .setPermissions(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA
            )
            .check()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) { // startActivityForResult를 통해서 기본 카메라 앱으로 받아온 사진 결과값
        super.onActivityResult(requestCode, resultCode, data)

        //이미지를 성공적으로 가벼왔다면
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val bitmap: Bitmap
            val file = File(curPhotoPath)
            if (Build.VERSION.SDK_INT < 28) { //안드로이드 9.8 버전보다 낮을 경우
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(file))
                binding.ivProfile.setImageBitmap(bitmap)

            } else {//안드로이드 9.8 버전보다 높을 경우
                val decode = ImageDecoder.createSource(
                    this.contentResolver,
                    Uri.fromFile(file)
                )
                bitmap = ImageDecoder.decodeBitmap(decode)
                binding.ivProfile.setImageBitmap(bitmap)
            }
            savePhoto(bitmap)
        }
    }

    //갤러리에 저장
    private fun savePhoto(bitmap: Bitmap) {
//    val folderPath = Environment.getExternalStorageDirectory().absolutePath + "/Pictures/" // 사진폴더로 저장하기 위한 경로 선언
//    val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//    val fileName = "${timestamp}.jpeg"
//    val folder = File(folderPath)
//    if(!folder.isDirectory){//현재 해당 경로에 폴더가 존재하지 않는다면
//            folder.mkdirs() //make directory 줄임말로 해당 결로에 폴더 자동으로 생성
//        }
//    //실제적인 저장처리
//    val out = FileOutputStream(folderPath + fileName)
//    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
//    Toast.makeText(this,"사진이 앨범에 저장되었습니다", Toast.LENGTH_SHORT).show()
//    }

        val fileName = System.currentTimeMillis().toString() + ".png"
        val externalStorage = Environment.getExternalStorageDirectory().absolutePath
        val path = "$externalStorage/DCIM/imageSave"
        val dir = File(path)

        if (dir.exists().not()) {
            dir.mkdirs() // 폴더 없을경우 폴더 생성
        }


        val fileItem = File("$dir/$fileName")
        fileItem.createNewFile()
        //0KB 파일 생성.
        val fos = FileOutputStream(fileItem) // 파일 아웃풋 스트림
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos) //파일 아웃풋 스트림 객체를 통해서 Bitmap 압축.
        Toast.makeText(this,"사진이 앨범에 저장되었습니다", Toast.LENGTH_SHORT).show()

    }
}