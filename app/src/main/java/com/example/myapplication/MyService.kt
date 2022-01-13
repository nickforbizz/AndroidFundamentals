package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {

    var TAG = "MyService"

    init {
        Log.d(TAG,"Service Running ...")
    }
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG,dataString)
        }
        
        // to run another thread
        Thread{
            // start your complex calculations
        }.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG,"Service is being destroyed ..")
    }
}