package com.example.pruebapt

import com.example.pruebapt.data.network.ApiServiceBank
import com.google.gson.GsonBuilder
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class ApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var banksapi: ApiServiceBank
    @Before
    fun setUp(){
        mockWebServer = MockWebServer()
        banksapi = Retrofit.Builder()
             .baseUrl(mockWebServer.url("https://dev.obtenmas.com"))
             .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
             .build()
             .create(ApiServiceBank::class.java)
    }

    @Test
    suspend fun testBanks(){
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)
        val response = banksapi.getBankInfo()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, response.isEmpty())
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}