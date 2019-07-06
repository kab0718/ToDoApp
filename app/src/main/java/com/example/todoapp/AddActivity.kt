package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import org.jetbrains.anko.db.insert

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val task = findViewById<EditText>(R.id.Add_task)
        val other = findViewById<EditText>(R.id.other)

        AddButton.setOnClickListener {
            var helper = TasksDatabaseHelper.getInstance(this)

            helper.use {
                insert(TasksDatabaseHelper.tableName, *arrayOf("task" to task.text, "other" to other.text))
            }

            Toast.makeText(applicationContext, "タスクを追加", Toast.LENGTH_LONG).show()

        }

        BackButton.setOnClickListener {
            val intent = Intent(application,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
