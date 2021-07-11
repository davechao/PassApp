package com.migo.migoapp.mockapi

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class StatusApiTest : BaseApiTest() {

    @Test
    fun getStatus() {
        enqueueResponse(ApiResult.Success, "status.json")

        val result = runBlocking {
            service.getStatus()
        }

        val request = mockWebServer.takeRequest()
        assertEquals(request.path, "/status")

        if (result.isSuccessful) {
            val apiStatusItem = result.body()
            assertEquals(apiStatusItem?.status, 200)
            assertEquals(apiStatusItem?.message, "OK")
        }
    }
}