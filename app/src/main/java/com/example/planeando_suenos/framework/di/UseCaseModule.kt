package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.usescases.LoginCase
import com.example.planeando_suenos.usescases.MainCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providerMainCase(
    ): MainCase {
        return MainCase()
    }

    @Singleton
    @Provides
    fun providerLoginCase(
    ): LoginCase {
        return LoginCase(
        )
    }
}