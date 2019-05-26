package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        BackButton.setOnClickListener {
            val intent = Intent(application,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
