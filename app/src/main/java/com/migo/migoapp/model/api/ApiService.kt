package com.migo.migoapp.model.api

import com.migo.migoapp.model.api.vo.ApiStatusItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/status")
    suspend fun getPublicStatus(): Response<ApiStatusItem>

}