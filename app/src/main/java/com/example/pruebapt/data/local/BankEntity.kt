package com.example.pruebapt.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Banks")
data class BankEntity(
    @PrimaryKey
    val uid: Int,
    val description: String,
    val age: Int,
    val url: String,
    val name: String
)
