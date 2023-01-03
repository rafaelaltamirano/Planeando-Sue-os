package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.data.dao.AuthDao
import com.example.planeando_suenos.data.dao.SmartShoppingDao
import com.example.planeando_suenos.data.dao.UserDao
import com.example.planeando_suenos.framework.datasource.AuthDaoImp
import com.example.planeando_suenos.framework.datasource.SmartShoppingDaoImp
import com.example.planeando_suenos.framework.datasource.UserDaoImp
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

    @Binds
    @Singleton
    abstract fun bindUserDao(imp: UserDaoImp): UserDao

    @Binds
    @Singleton
    abstract fun bindSmartShoppingDao(imp: SmartShoppingDaoImp): SmartShoppingDao

}