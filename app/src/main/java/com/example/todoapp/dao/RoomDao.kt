package com.example.todoapp.dao

import androidx.room.*
import com.example.todoapp.model.Task
import java.util.*

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task): Long

    @Query("SELECT * FROM task")
    fun allTask(): List<Task>

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)

}