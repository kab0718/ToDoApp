package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val tasksDatabaseHelper = TasksDatabaseHelper(this)

        AddButton.setOnClickListener { view -> val task = TaskModel(Add_task.text.toString(), other.text.toString())
            val result = tasksDatabaseHelper.insertTask(task)

            if(result){
                Toast.makeText(this,"new Task Added!", LENGTH_LONG).show()
            }
        }

        BackButton.setOnClickListener {
            val intent = Intent(application,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
