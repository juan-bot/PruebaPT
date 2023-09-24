package com.example.pruebapt.data.model

import com.google.gson.annotations.SerializedName

data class BankResponse(
    @SerializedName("age")
    val age: Int,
    @SerializedName("bankName")
    val bankName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String
    )

