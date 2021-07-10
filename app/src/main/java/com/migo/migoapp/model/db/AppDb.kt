package com.migo.migoapp.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.migo.migoapp.model.db.vo.Pass

@Database(entities = [Pass::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun passDao(): PassDao
}