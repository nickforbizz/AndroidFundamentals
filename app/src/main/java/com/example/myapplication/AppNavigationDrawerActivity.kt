package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_app_navigation_drawer.*

class AppNavigationDrawerActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_navigation_drawer)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



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
}