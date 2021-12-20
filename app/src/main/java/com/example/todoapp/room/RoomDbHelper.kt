package com.example.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.dao.RoomDao
import com.example.todoapp.model.Task

@Database(entities = [Task::class], version = 1)
abstract class RoomDbHelper : RoomDatabase() {

    abstract fun roomDao(): RoomDao

    object DatabaseBuilder {

        private var instance: RoomDbHelper? = null

        fun getInstance(context: Context): RoomDbHelper {

            if (instance == null) {
                synchronized(RoomDbHelper::class.java) {
                    instance = buildRoomDb(context)
                }
            }
            return instance!!
        }

        private fun buildRoomDb(context: Context) =
            Room.databaseBuilder(context.applicationContext, RoomDbHelper::class.java, "task.db")
                .allowMainThreadQueries().build()
    }
}