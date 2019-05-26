package com.example.todoapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class TasksDatabaseHelper(context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    @Throws(SQLiteException::class)
    fun insertTask(task:TaskModel):Boolean{
        val db = writableDatabase

        val values = ContentValues()
        values.put(DBContract.TaskEntry.TASK_NAME, task.name)
        values.put(DBContract.TaskEntry.OTHER, task.other)

        val rowId = db.insert(DBContract.TaskEntry.TABLE_NAME,null,values)

        return true
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "TASKS.db"

        private const val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DBContract.TaskEntry.TABLE_NAME + " (" +
                        DBContract.TaskEntry.TASK_NAME + " TEXT ," +
                        DBContract.TaskEntry.OTHER + " TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS" + DBContract.TaskEntry.TABLE_NAME
    }

}