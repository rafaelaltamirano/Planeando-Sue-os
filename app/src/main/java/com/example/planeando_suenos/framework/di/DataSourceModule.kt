package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.data.dao.AuthDao
import com.example.planeando_suenos.framework.datasource.AuthDaoImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindAuthDao(imp: AuthDaoImp): AuthDao

}