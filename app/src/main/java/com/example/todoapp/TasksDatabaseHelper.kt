package com.example.todoapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.createTable

class TasksDatabaseHelper(context:Context) : ManagedSQLiteOpenHelper(context, "taskdb.db", null, 1){

    companion object{
        val tableName = "Tasks"
        private var instance : TasksDatabaseHelper? = null

        fun getInstance(context: Context):TasksDatabaseHelper{
            return instance ?: TasksDatabaseHelper(context.applicationContext)!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(tableName, ifNotExists = true, columns = *arrayOf("task" to TEXT, "other" to TEXT))
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}