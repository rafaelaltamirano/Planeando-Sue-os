package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.data.dao.AccessTokensRepository
import com.example.planeando_suenos.framework.retrofit.authentication.AuthenticationApi
import com.example.planeando_suenos.framework.retrofit.smartShopping.SmartShoppingApi
import com.example.planeando_suenos.framework.retrofit.users.UsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient(accessTokensRepo: AccessTokensRepository): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor {
                val accessTokens = accessTokensRepo.accessTokens
                val builder = it.request().newBuilder()
                accessTokens?.also { (token) ->  builder.addHeader("tokenjwt", token) }
                it.proceed(builder.build())
            }
            .build()
    }
    @Provides
    fun providesAuthenticationApi(): AuthenticationApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_AUTH)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(AuthenticationApi::class.java)
    }

    @Provides
    fun providesUsersApi(client: OkHttpClient): UsersApi {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL_USERS)
            .addConverterFactory(GsonConverterFactory.create())
        client.also(builder::client)
        return builder.build().create(UsersApi::class.java)
    }

    @Provides
    fun providesSmartShoppingApi(client: OkHttpClient): SmartShoppingApi {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL_SMART_SHOPPING)
            .addConverterFactory(GsonConverterFactory.create())
        client.also(builder::client)
        return builder.build().create(SmartShoppingApi::class.java)
    }

}