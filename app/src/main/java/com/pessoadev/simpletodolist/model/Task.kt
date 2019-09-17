package com.pessoadev.simpletodolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    val task : String,
    @PrimaryKey (autoGenerate = true) val id : Int = 0

)