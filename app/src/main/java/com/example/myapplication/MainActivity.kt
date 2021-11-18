package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnOrder.setOnClickListener {
            val checkedMeatRadioBtnId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioBtnId)

            val beef = cbBeef.isChecked
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked

            val resOrder = "You have orderd a bugger with;\n" +
                    "${meat.text}" +
                    (if(beef) "\nBeef" else "") +
                    (if(cheese) "\ncheese" else "") +
                    (if(onions) "\nonions" else "")

            tvRes.text  = resOrder
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
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
        }
        return true
    }
}