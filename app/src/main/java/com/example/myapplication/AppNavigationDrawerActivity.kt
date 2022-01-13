package com.example.myapplication

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_app_navigation_drawer.*

class AppNavigationDrawerActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var receiver: AirplaneBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_navigation_drawer)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        // Broadcast Events
        receiver = AirplaneBroadcastReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        // start and stop intent service
//        btnStartService.setOnClickListener{
//            Intent(this, myIntentService::class.java).also {
//                startService(it)
//                txtServiceMsg.text = "Service Started"
//            }
//        }

        btnStartService.setOnClickListener{
            Intent(this, MyService::class.java).also {
                startService(it)
                txtServiceMsg.text = "Service Started"
            }
        }

        btnStopService.setOnClickListener{
            Intent(this, MyService::class.java).also {
                stopService(it)
                txtServiceMsg.text = "Service Stopped"
            }
        }

        btnSendData.setOnClickListener{
            Intent(this, MyService::class.java).also {
                val data_stream = etDataString.text.toString()
                it.putExtra("EXTRA_DATA", data_stream)
                txtServiceMsg.text = "Service Stopped"
                startService(it)
            }
        }




        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miSettings -> Toast.makeText(this, "settings clicked", Toast.LENGTH_LONG).show()
                R.id.miToast -> Intent(this, ToastActivity::class.java).also {
                    startActivity(it)
                }
                R.id.miAlertdialog -> Intent(this, AlertdialogsActivity::class.java).also {
                    startActivity(it)
                }
                R.id.miSpinners -> Intent(this, SpinnerActivity::class.java).also {
                    startActivity(it)
                }
                R.id.miFragments -> Intent(this, FlagmentActivity::class.java).also {
                    startActivity(it)
                }
                R.id.miBottomNav -> Intent(this, BottomNavActivity::class.java).also {
                    startActivity(it)
                }
                R.id.miViewPager -> Intent(this, ViewPagerActivity::class.java).also {
                    startActivity(it)
                }
                R.id.miSharepref -> Intent(this, SharedPreferencesActivity::class.java).also {
                    startActivity(it)
                }
                R.id.miNotification -> Intent(this, NotificationActivity::class.java).also {
                    startActivity(it)
                }
            }
            true
        }



    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return  true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver);
    }
}