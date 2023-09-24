package com.example.pruebapt.data.local

import android.content.Context
import androidx.room.Room

class DataBase (private val context: Context){
    private var dataBase: AppDataBase? = null
    private val DB_NAME = "banks_database"
    suspend fun createDatabase() {
        dataBase = Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME)
            .allowMainThreadQueries().build()
        // fallbackToDestructiveMigration()
        if (!dataBase!!.isOpen) {
            val pathDB = dataBase!!.openHelper.writableDatabase
            println("DB PATH: $pathDB")
        }
    }
    suspend fun getDB(): AppDataBase {
        if (dataBase == null) {
            createDatabase()
        }
        return dataBase!!
    }
}