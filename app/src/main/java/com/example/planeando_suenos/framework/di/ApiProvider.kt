package com.example.planeando_suenos.framework.di

import com.example.planeando_suenos.framework.api.schemas.response.SuenosApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object ApiProvider {
//
//    fun getSuenosApi(baseUrl: String, client: OkHttpClient? = null): SuenosApi {
//        val builder = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//        client?.also(builder::client)
//        return builder.build().create(SuenosApi::class.java)
//    }
//}