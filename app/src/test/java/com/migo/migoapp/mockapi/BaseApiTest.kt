package com.migo.migoapp.mockapi

import com.google.gson.Gson
import com.migo.migoapp.model.api.ApiService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var service: ApiService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()

        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ApiService::class.java)
    }

    @After
    fun dropdown() {
        mockWebServer.shutdown()
    }

    fun enqueueResponse(apiResult: ApiResult, fileName: String = "", headers: Map<String, String> = emptyMap()) {
        when (apiResult) {
            ApiResult.Empty -> mockWebServer.enqueue(MockResponse().setResponseCode(204))
            ApiResult.Success -> {
                val classloader = javaClass.classLoader
                val inputStream = classloader.getResourceAsStream("api-response/$fileName")
                val source = inputStream.source().buffer()
                val mockResponse = MockResponse()
                for ((key, value) in headers) {
                    mockResponse.addHeader(key, value)
                }
                mockWebServer.enqueue(mockResponse.setBody(source.readString(Charsets.UTF_8)))
            }
        }
    }
}