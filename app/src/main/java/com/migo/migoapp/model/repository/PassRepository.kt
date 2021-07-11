package com.migo.migoapp.model.repository

import com.migo.migoapp.model.db.AppDb
import com.migo.migoapp.model.db.PassDao
import com.migo.migoapp.model.db.vo.Pass
import com.migo.migoapp.model.emuns.PassStatus
import com.migo.migoapp.model.emuns.PassTitleType
import com.migo.migoapp.model.emuns.PassType
import com.migo.migoapp.model.vo.PassListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PassRepository constructor(db: AppDb) {

    private val passDao: PassDao = db.passDao()

    fun fetchStorePass(): ArrayList<PassListItem> {
        val dayPasses = arrayListOf<Pass>()
        dayPasses.add(
            Pass(
                name = "1 Day Pass",
                price = "Rp 2.000",
                type = PassType.DAY,
            )
        )
        dayPasses.add(
            Pass(
                name = "3 Day Pass",
                price = "Rp 5.000",
                type = PassType.DAY
            )
        )
        dayPasses.add(
            Pass(
                name = "7 Day Pass",
                price = "Rp 10.000",
                type = PassType.DAY
            )
        )

        val hourPasses = arrayListOf<Pass>()
        hourPasses.add(
            Pass(
                name = "1 Hour Pass",
                price = "Rp 500",
                type = PassType.HOUR
            )
        )
        hourPasses.add(
            Pass(
                name = "8 Hour Pass",
                price = "Rp 1.000",
                type = PassType.HOUR
            )
        )

        val passes = arrayListOf<PassListItem>()
        passes.add(PassListItem(PassTitleType.DAY, dayPasses))
        passes.add(PassListItem(PassTitleType.HOUR, hourPasses))

        return passes
    }

    suspend fun getMyPass(): Flow<List<PassListItem>> {
        return flow {
            val passes = arrayListOf<PassListItem>()
            val dayPasses = arrayListOf<Pass>()
            val hourPasses = arrayListOf<Pass>()

            val result = passDao.getAllPass()
            result.forEach { pass ->
                when (pass.type) {
                    PassType.DAY -> dayPasses.add(pass)
                    else -> hourPasses.add(pass)
                }
            }

            if (dayPasses.isNotEmpty()) {
                passes.add(PassListItem(PassTitleType.DAY, dayPasses))
            }

            if (hourPasses.isNotEmpty()) {
                passes.add(PassListItem(PassTitleType.HOUR, hourPasses))
            }

            emit(passes)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun buyPass(pass: Pass): Flow<Pass?> {
        return flow {
            passDao.insertPass(pass)
            emit(pass)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun activateMyPass(pass: Pass): Flow<Pass?> {
        return flow {
            passDao.update(pass)
            emit(pass)
        }.flowOn(Dispatchers.IO)
    }
}