package com.example.pruebapt.data.network

import com.example.pruebapt.data.model.BankResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceBank {
    @GET("/catom/api/challenge/banks")
    suspend fun getBankInfo(): List<BankResponse>
}