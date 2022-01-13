package com.example.myapplication

import android.app.IntentService
import android.content.Intent
import android.util.Log

class myIntentService: IntentService("myIntentService"){

    init {
        intent = this
    }
    companion object{
        private lateinit var intent: myIntentService
        var isRunning = false

        fun stop(){
            Log.d("myIntentService", "Service stopping")
            isRunning = false
            intent.stopSelf()
        }
    }


    override fun onHandleIntent(p0: Intent?) {
       try {
           isRunning = true
           while (isRunning){
               Log.d("myIntentService", "Service Running ...")
               Thread.sleep(1000)
           }
       }catch (e: InterruptedException){
           Thread.currentThread().interrupt()
       }
    }
}