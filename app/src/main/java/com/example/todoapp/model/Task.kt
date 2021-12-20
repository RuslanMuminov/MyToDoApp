package com.example.todoapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var note: String? = null,
    var time: String? = null
)
