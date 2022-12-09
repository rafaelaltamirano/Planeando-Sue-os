package com.example.planeando_suenos.framework.di




//@Module
//@InstallIn(SingletonComponent::class)
//object ApiModule {
//
//    @Singleton
//    @Provides
//    fun provideHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .readTimeout(60, TimeUnit.SECONDS)
//            .connectTimeout(60, TimeUnit.SECONDS)
//            .addInterceptor {
//                val builder = it.request().newBuilder()
//                it.proceed(builder.build())
//            }
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun providerReposApi(
//        client: OkHttpClient
//    ): SuenosApi {
//        val baseURL = ""
//        return getSuenosApi(baseURL, client)
//    }
//}