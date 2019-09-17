package com.pessoadev.simpletodolist.di

import androidx.room.Room
import com.pessoadev.simpletodolist.repository.TaskDatabase
import com.pessoadev.simpletodolist.repository.TaskRepository
import com.pessoadev.simpletodolist.task.TaskViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val todo = module {
    single { Room.databaseBuilder(get(), TaskDatabase::class.java, "tasks_database")
        .fallbackToDestructiveMigration()
        .build() }

    single { get<TaskDatabase>().taskDao() }
    single { TaskRepository(get()) }
    viewModel { TaskViewModel(get()) }




}