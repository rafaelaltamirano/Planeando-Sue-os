package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.data.adapters.FieldValidator
import com.example.planeando_suenos.framework.adapters.FieldValidatorImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AdaptersModule {

    @Binds
    @Singleton
    abstract fun bindFieldValidator(imp: FieldValidatorImp): FieldValidator

}