package com.rago.data.di

import com.rago.data.api.PokemonApiService
import com.rago.data.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//TODO: 2.4 creando modulo para inyeccion de clases retrofit o cualquiera relacionado a network
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //TODO 2.6 agregando interceptor para ver peticiones en el logcat
    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(logInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    //TODO 2.7 configurando retrofit
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).client(okHttpClient).build()


    //TODO 2.10 creando api service para consultar con retrofit
    @Provides
    @Singleton
    fun providePokemonApiService(retrofit: Retrofit): PokemonApiService =
        retrofit.create(PokemonApiService::class.java)
}