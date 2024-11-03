package com.subash.backgroundservice

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS,
                    android.Manifest.permission.FOREGROUND_SERVICE_LOCATION,
                    android.Manifest.permission.ACCESS_FINE_LOCATION),
                0
            )
        }
        setContentView(R.layout.activity_main)
         findViewById<Button>(R.id.start).setOnClickListener {
            Intent(applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.START.toString()
                startService(it)
            }
        }
        findViewById<Button>(R.id.stop).setOnClickListener {
            Intent(applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.STOP.toString()
                stopService(it)
            }
        }

//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}