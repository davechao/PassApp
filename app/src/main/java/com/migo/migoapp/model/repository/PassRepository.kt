package com.migo.migoapp.model.repository

import com.migo.migoapp.model.db.AppDb
import com.migo.migoapp.model.db.PassDao
import com.migo.migoapp.model.db.vo.Pass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PassRepository constructor(db: AppDb) {

    private val passDao: PassDao = db.passDao()

    suspend fun getAllPass(): Flow<List<Pass>> {
        return flow {
            val result = passDao.getAll()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}