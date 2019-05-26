package com.example.todoapp

import android.provider.BaseColumns

object DBContract{
    class TaskEntry : BaseColumns{
        companion object{
            const val TABLE_NAME = "tasks"
            const val TASK_NAME = "task_name"
            const val OTHER = "other"
        }
    }
}
