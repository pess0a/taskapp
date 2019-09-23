package com.pessoadev.taskapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pessoadev.taskapp.model.Task

@Database(entities = [Task::class], version = 4)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao() : TaskDao
}