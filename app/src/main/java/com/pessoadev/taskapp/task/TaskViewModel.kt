package com.pessoadev.taskapp.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pessoadev.taskapp.repository.TaskRepository
import com.pessoadev.taskapp.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel(), CoroutineScope by CoroutineScope(
    Dispatchers.Main
) {

    var allTasks: MutableLiveData<List<Task>> = MutableLiveData()

    fun loadTasks() {
        try {
            launch {
                taskRepository.allTasks().apply {
                    allTasks.postValue(this.reversed())
                }
            }
        } catch (e : Exception) {
            e.printStackTrace()
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