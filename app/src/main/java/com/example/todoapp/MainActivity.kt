package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener{
            val intent = Intent(application, AddActivity::class.java)
            startActivity(intent)
        }

        confirmation.setOnClickListener {
            val intent2 = Intent(application, ConfirmationActivity::class.java)
            startActivity(intent2)
        }
    }
}
