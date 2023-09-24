package com.example.pruebapt.presentation

import com.google.gson.annotations.SerializedName

data class BankModel(
    var age: Int,
    val bankName: String,
    val description: String,
    val url: String
)
