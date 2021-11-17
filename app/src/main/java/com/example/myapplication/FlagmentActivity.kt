package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_flagment.*

class FlagmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flagment)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFlagments, firstFragment)
            commit()
        }

        btnFlagment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFlagments, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        btnFlagment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFlagments, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}