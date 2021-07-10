package com.migo.migoapp.model.db

import DB_NAME
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.migo.migoapp.model.db.vo.Pass

@Database(entities = [Pass::class], version = 1)
abstract class AppDb : RoomDatabase() {

    companion object {
        fun create(context: Context, useInMemory: Boolean = true): AppDb {
            val databaseBuilder = when {
                useInMemory -> Room.inMemoryDatabaseBuilder(
                    context,
                    AppDb::class.java
                )
                else -> Room.databaseBuilder(
                    context,
                    AppDb::class.java,
                    DB_NAME
                )
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun passDao(): PassDao
}