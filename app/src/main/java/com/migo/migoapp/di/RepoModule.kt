package com.migo.migoapp.di

import com.migo.migoapp.model.api.ApiService
import com.migo.migoapp.model.db.AppDb
import com.migo.migoapp.model.repository.ApiRepository
import com.migo.migoapp.model.repository.PassRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {

    @Provides
    fun provideApiRepository(apiService: ApiService): ApiRepository {
        return ApiRepository(apiService)
    }

    @Provides
    fun providePassRepository(db: AppDb): PassRepository {
        return PassRepository(db)
    }
}