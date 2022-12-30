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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun providesAuthenticationApi(): AuthenticationApi {
        return Retrofit.Builder().baseUrl(BASE_URL_AUTH)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(AuthenticationApi::class.java)
    }


    @Provides
    fun providesUsersApi(): UsersApi {
        return Retrofit.Builder().baseUrl(BASE_URL_USERS)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(UsersApi::class.java)
    }

    @Provides
    fun providesSmartShoppingApi(): SmartShoppingApi {
        return Retrofit.Builder().baseUrl(BASE_URL_SMART_SHOPPING)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(SmartShoppingApi::class.java)
    }
}