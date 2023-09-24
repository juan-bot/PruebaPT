package com.example.pruebapt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BankEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun bankDao(): BankDao
}