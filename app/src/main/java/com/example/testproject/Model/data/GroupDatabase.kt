package com.example.testproject.Model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Group::class], version = 1, exportSchema = false)
abstract class GroupDatabase: RoomDatabase() {

    abstract fun groupDao(): GroupDao

    companion object{
        @Volatile
        private var INSTNACE: GroupDatabase? = null

        fun getDatabase(context: Context): GroupDatabase{
            val tempInstance = INSTNACE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance  = Room.databaseBuilder(
                    context.applicationContext,
                    GroupDatabase::class.java,
                    "group_database"
                ).build()
                INSTNACE = instance
                return instance
            }
        }
    }
}