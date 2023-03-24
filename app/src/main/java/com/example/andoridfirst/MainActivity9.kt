package com.example.andoridfirst

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import androidx.core.app.NotificationCompat
import com.example.andoridfirst.databinding.ActivityMain9Binding

class MainActivity9 : AppCompatActivity() {
    lateinit var binding: ActivityMain9Binding
    lateinit var manager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNotification.setOnClickListener {
            // 1. notificationManager 객체 참조 변수를 만듬
            // 1. notificationCompat.Builder 객체 참조 변수를 만듬
            manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder
            // 2. channer 객체 참조 변수를 만듬. (API 26버전 이상부터 채널을 만들어야함
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // 3. 26버전 이상 채널 객체 참조 변수를 만듬
                val channelId = "ych-channel"
                val channelName = "My YCH Channel"
                val channel =
                    NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)

                // 채널에 대한 정보를 등록
                channel.description = "My YCH Channel Description"
                channel.setShowBadge(true)
                // 알림음 오디오 설정
                val notificationUri: Uri =
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributesBuilder = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                channel.setSound(notificationUri, audioAttributesBuilder)
                channel.enableLights(true)
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(500, 1000, 500, 200, 1000)
                // 4. 채널을 등록 notificationManager
                manager.createNotificationChannel(channel)
                // 5. 채널 아이디를 이용해서 빌더 생성
                builder = NotificationCompat.Builder(this, channelId)

            } else {
                // 5.채널 아이디를 이용하지 않고 빌더 생성
                builder = NotificationCompat.Builder(this)
            }
            // 6. builder 알림창이 어떤방법으로 구현할지 보여주는 것
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            builder.setContentTitle("My First Notification")
            builder.setContentText("My First Notification content")
            builder.setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.na02))
            // 7. 알림이 발생 후 터치 시 내가 지정한 액티비티로 화면 전환하는 pendingIntent 기능 부여
            // 7. 알림이 발생 후 터치시 broadCast 화면으로 정보를 알려준다.
//            val intent = Intent(this, DetailActivity::class.java)
//            val pendingIntent = PendingIntent.getActivity(this,10, intent, PendingIntent.FLAG_IMMUTABLE)
//            builder.setContentIntent(pendingIntent)

            // 8. 알림에 액션등록하기
//            val actionIntent = Intent(this, OneReceiver::class.java)
//            val actionPendingIntent = PendingIntent.getBroadcast(this,20,actionIntent,PendingIntent.FLAG_IMMUTABLE)
//            builder.addAction(NotificationCompat.Action.Builder(
//                android.R.drawable.stat_notify_more,
//                "Action",
//                actionPendingIntent
//            ).build())
            // 9. 알림창에서 데이터를 입력하면 해당되는 데이터를 브로드캐스터로 받아옴.
            // 9-1. 알림창에서 입력할 수 있는 기능 부여
            val remoteInput : androidx.core.app.RemoteInput = androidx.core.app.RemoteInput.Builder("ych_noti_reply").run {
                setLabel("답장 써주십시오.")
                build()
            }
            val actionIntent = Intent(this, OneReceiver::class.java)
            val actionPendingIntent = PendingIntent.getBroadcast(this,30,actionIntent,PendingIntent.FLAG_MUTABLE)
            builder.addAction(NotificationCompat.Action.Builder(
                R.drawable.cancel,
                "답장",
                actionPendingIntent
            ).addRemoteInput(remoteInput).build())
            // 10. manager 통하여 알림 발생
            manager.notify(10, builder.build())
        }
        binding.btnNotificationCancel.setOnClickListener{
            manager.cancel(10)
        }
    }
}