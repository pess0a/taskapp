package com.pessoadev.simpletodolist.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pessoadev.simpletodolist.model.Task

@Database(entities = [Task::class], version = 3)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao() : TaskDao
}