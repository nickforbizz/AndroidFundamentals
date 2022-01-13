package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(Context: Context?, Intent: Intent?) {
        var isAirplaneModeEnabled = Intent?.getBooleanExtra("state", false) ?: return
        if (isAirplaneModeEnabled){
            Toast.makeText(Context,"Airplane Mode has been Enabled", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(Context,"Airplane Mode has been Disabled", Toast.LENGTH_LONG).show()
        }
    }
}