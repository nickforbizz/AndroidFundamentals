package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_alertdialogs.*

class AlertdialogsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alertdialogs)



        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add John to your contacts?")
            .setIcon(R.drawable.ic_user)
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this, "Contact added", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){ _, _ ->
                Toast.makeText(this, "Contact was not added", Toast.LENGTH_LONG).show()
            }
            .create()

        btnAddContact.setOnClickListener {
            addContactDialog.show()
        }



        val options_arr = arrayOf("First class", "Second Class", "Pass")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Select Your Grade")
            .setSingleChoiceItems(options_arr, 0){dialogInterface, i ->
                Toast.makeText(this, "You clicked ${options_arr[i]}", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this, "Processing Info", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){ _, _ ->
                Toast.makeText(this, "Process Cancelled", Toast.LENGTH_LONG).show()
            }
            .create()


        btnSingleChoice.setOnClickListener {
            singleChoiceDialog.show()
        }


        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Select Your Grade")
            .setMultiChoiceItems(options_arr, booleanArrayOf(false, false, false)){_, i, isChecked ->
                if (isChecked){
                    Toast.makeText(this, "You checked ${options_arr[i]}", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "You unchecked ${options_arr[i]}", Toast.LENGTH_LONG).show()
                }
            }
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this, "Processing Info", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){ _, _ ->
                Toast.makeText(this, "Process Cancelled", Toast.LENGTH_LONG).show()
            }
            .create()


        btnMultiChoice.setOnClickListener {
            multiChoiceDialog.show()
        }


    }

}