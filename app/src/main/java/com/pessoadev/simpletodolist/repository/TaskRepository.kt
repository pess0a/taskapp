package com.pessoadev.simpletodolist.repository

import com.pessoadev.simpletodolist.model.Task

class TaskRepository (private val taskDao: TaskDao){

    suspend fun allTasks() : List<Task> {
        return taskDao.getAllTasks()
    }

    suspend fun insert(task : Task) {
        taskDao.insertTask(task)
    }
}