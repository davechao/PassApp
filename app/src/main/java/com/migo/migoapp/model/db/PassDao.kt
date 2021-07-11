package com.migo.migoapp.model.db

import androidx.room.*
import com.migo.migoapp.model.db.vo.Pass

@Dao
interface PassDao {

    @Query("SELECT * FROM pass")
    fun getAllPass(): List<Pass>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPass(pass: Pass)

    @Update
    fun updatePass(pass: Pass)
}