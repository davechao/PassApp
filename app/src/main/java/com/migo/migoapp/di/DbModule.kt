package com.migo.migoapp.di

import android.content.Context
import com.migo.migoapp.model.db.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context): AppDb {
        return AppDb.create(context, false)
    }
}