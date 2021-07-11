package com.migo.migoapp.model.repository

import com.migo.migoapp.model.api.ApiService
import com.migo.migoapp.model.api.vo.ApiStatusItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

class ApiRepository constructor(private val apiService: ApiService) {

    suspend fun getApiStatus(): Flow<ApiStatusItem?> {
        return flow {
            val result = apiService.getStatus()
            if (!result.isSuccessful) throw HttpException(result)
            emit(result.body())
        }.flowOn(Dispatchers.IO)
    }
}