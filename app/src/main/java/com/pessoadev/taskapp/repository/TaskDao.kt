package com.pessoadev.taskapp.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pessoadev.taskapp.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task : Task) : Long

    @Query("SELECT * FROM task")
    suspend fun getAllTasks() : List<Task>
}
