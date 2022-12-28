package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.framework.retrofit.authentication.AuthenticationApi
import com.example.planeando_suenos.framework.retrofit.smartShopping.SmartShoppingApi
import com.example.planeando_suenos.framework.retrofit.users.UsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun providesAuthenticationApi(): AuthenticationApi {
        return Retrofit.Builder().baseUrl("http://44.198.182.248:3001/authentication/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(AuthenticationApi::class.java)
    }

    @Provides
    fun providesUsersApi(): UsersApi {
        return Retrofit.Builder().baseUrl("http://44.198.182.248:3002/users/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(UsersApi::class.java)
    }

    @Provides
    fun providesSmartShoppingApi(): SmartShoppingApi {
        return Retrofit.Builder().baseUrl("http://44.198.182.248:3004/smartShopping/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(SmartShoppingApi::class.java)
    }
}