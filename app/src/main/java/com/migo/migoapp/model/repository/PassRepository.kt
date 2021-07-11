package com.migo.migoapp.model.repository

import com.migo.migoapp.model.db.AppDb
import com.migo.migoapp.model.db.PassDao
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.vo.PassListItem
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

    fun fetchStorePass(): ArrayList<PassListItem> {
        val dayPasses = arrayListOf<Pass>()
        dayPasses.add(Pass(name = "1 Day Pass", price = "Rp 2.000"))
        dayPasses.add(Pass(name = "3 Day Pass", price = "Rp 5.000"))
        dayPasses.add(Pass(name = "7 Day Pass", price = "Rp 10.000"))

        val hourPasses = arrayListOf<Pass>()
        hourPasses.add(Pass(name = "1 Hour Pass", price = "Rp 500"))
        hourPasses.add(Pass(name = "8 Hour Pass", price = "Rp 1.000"))

        val passes = arrayListOf<PassListItem>()
        passes.add(PassListItem("DAY PASS", dayPasses))
        passes.add(PassListItem("HOUR PASS", hourPasses))

        return passes
    }
}