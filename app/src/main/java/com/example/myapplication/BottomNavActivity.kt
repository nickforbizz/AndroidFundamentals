package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        val homeFr = BNHomeFragment()
        val messagesFr = BNMessagesFragment()
        val profileFr = BNProfileFragment()

        setCurrentFragment(homeFr)

        bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mibHome -> setCurrentFragment(homeFr)
                R.id.mibMessages-> setCurrentFragment(messagesFr)
                R.id.mibProfile -> setCurrentFragment(profileFr)
            }
            true
        }

        bottomNavView.getOrCreateBadge(R.id.mibMessages).apply {
            number = 10
            isVisible = true
        }
    }



    private fun setCurrentFragment(fr: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frbnFragment, fr)
            commit()
        }
    }
}