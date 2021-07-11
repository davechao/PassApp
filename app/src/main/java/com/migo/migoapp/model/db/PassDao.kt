package com.migo.migoapp.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.migo.migoapp.model.db.vo.Pass

@Dao
interface PassDao {

    @Query("SELECT * FROM pass")
    fun getAll(): List<Pass>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPass(pass: Pass)
}