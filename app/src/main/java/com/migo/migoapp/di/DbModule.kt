package com.migo.migoapp.di

import DB_NAME
import androidx.room.Room
import com.migo.migoapp.App
import com.migo.migoapp.model.db.AppDb
import com.migo.migoapp.model.db.PassDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideAppDb(): AppDb {
        return Room.databaseBuilder(
            App.applicationContext(),
            AppDb::class.java,
            DB_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePassDao(appDb: AppDb): PassDao {
        return appDb.passDao()
    }
}