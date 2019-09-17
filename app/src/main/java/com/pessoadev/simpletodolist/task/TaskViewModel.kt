package com.pessoadev.simpletodolist.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pessoadev.simpletodolist.repository.TaskRepository
import com.pessoadev.simpletodolist.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    var allTasks: MutableLiveData<List<Task>> = MutableLiveData()

    fun loadTasks() {
        launch {
            taskRepository.allTasks().apply {
                allTasks.postValue(this.reversed())
            }
        }
    }

    fun insertTask(task: String) {
        try {
            launch {
                taskRepository.insert(Task(task)).apply {
                    loadTasks()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}