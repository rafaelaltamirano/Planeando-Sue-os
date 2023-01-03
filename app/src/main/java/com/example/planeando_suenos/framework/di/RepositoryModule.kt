package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.data.dao.AccessTokensRepository
import com.example.planeando_suenos.data.dao.AuthDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providerAccessTokensRepository(
        remote: AuthDao
    ): AccessTokensRepository {
        return AccessTokensRepository(remote)
    }
}