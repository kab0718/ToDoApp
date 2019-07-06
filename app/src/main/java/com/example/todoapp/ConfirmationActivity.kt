package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_confirmation.*
import org.jetbrains.anko.db.select

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val TasksHelper = TasksDatabaseHelper(this)
        val dataList = TasksHelper.readableDatabase.select(TasksDatabaseHelper.DATABASE_NAME).parseList<>

        list.adapter

        BackButton.setOnClickListener {
            val intent = Intent(application,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
