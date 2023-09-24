package com.example.pruebapt.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface BankDao {
    @Query("SELECT * FROM Banks")
    fun getAll(): List<BankEntity>

    @Insert
    fun insert(vararg bank: BankEntity)
}