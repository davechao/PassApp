package com.migo.migoapp.model.repository

import com.migo.migoapp.model.api.ApiService
import com.migo.migoapp.model.api.vo.ApiStatusItem
import com.migo.migoapp.model.emuns.ApiEnv
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class ApiRepository constructor(private val apiService: ApiService) {

    suspend fun getApiStatus(): Flow<ApiStatusItem?> {
        return flow {
            val result = apiService.getPublicStatus()
            if (!result.isSuccessful) throw HttpException(result)
            emit(result.body())
        }
    }
}